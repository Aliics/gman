use clap::{App, Arg};
use core::result;
use rand::Rng;
use std::io::{self, Read};
use std::{fs::File, num::ParseIntError};

const DICT: &str = "/etc/dictionaries-common/words";

#[derive(Default)]
struct Conf {
    count: i32,
    delimiter: String,
    keep_apostrophe: bool,
}

impl Conf {
    fn build() -> result::Result<Conf, ParseIntError> {
        let am = App::new("gman")
            .version("0.1.0")
            .args(&[
                Arg::with_name("count")
                    .help("amount of words to be generated")
                    .short("c")
                    .long("count")
                    .takes_value(true)
                    .default_value("1"),
                Arg::with_name("delimiter")
                    .help("word delimiter")
                    .short("d")
                    .long("delimiter")
                    .takes_value(true)
                    .default_value(" "),
                Arg::with_name("keep_apostrophe")
                    .help("keep the apostrophes of dictionary words")
                    .short("k")
                    .long("keep-apostrophe"),
            ])
            .get_matches();
        let count = am.value_of("count").unwrap().parse()?;
        let delimiter = am.value_of("delimiter").unwrap().to_owned();
        let keep_apostrophe = am.is_present("keep_apostrophe");
        Ok(Conf {
            count,
            delimiter,
            keep_apostrophe,
        })
    }
}

fn main() -> io::Result<()> {
    let conf = Conf::build().unwrap();
    let mut f = File::open(DICT)?;
    let mut data = Vec::new();
    f.read_to_end(&mut data)?;
    let words = group_words(&conf, data);
    let mut rng = rand::thread_rng();
    for i in 0..conf.count {
        let line = rng.gen_range(0..words.len());
        let word = words[line].as_str();
        let delimiter = if i < conf.count - 1 {
            conf.delimiter.as_str()
        } else {
            "\n"
        };
        print!("{}{}", word, delimiter);
    }
    Ok(())
}

fn group_words(conf: &Conf, bytes: Vec<u8>) -> Vec<String> {
    let mut word = String::new();
    let mut words = Vec::new();
    for b in bytes {
        let b = b as char;
        if b == '\n' {
            words.push(word);
            word = String::new();
        } else {
            if !conf.keep_apostrophe && b == '\'' {
                continue;
            }
            word.push(b);
        }
    }
    words
}

#[cfg(test)]
mod tests {
    use crate::{group_words, Conf};

    #[test]
    fn grouped() {
        let separated: Vec<u8> = vec![b'a', b'b', b'c', b'\n', b'd', b'e', b'f', b'\n'];
        let words = group_words(&Conf::default(), separated);
        assert_eq!(words, vec!["abc", "def"]);
    }
}
