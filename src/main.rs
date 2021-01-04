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
    lower_case: bool,
    upper_case: bool,
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
                Arg::with_name("lower_case")
                    .help("make all words lower cased")
                    .short("l")
                    .long("lower-case"),
                Arg::with_name("upper_case")
                    .help("make all words upper cased")
                    .short("u")
                    .long("upper-case"),
            ])
            .get_matches();
        Ok(Conf {
            count: am.value_of("count").unwrap().parse()?,
            delimiter: am.value_of("delimiter").unwrap().to_owned(),
            keep_apostrophe: am.is_present("keep_apostrophe"),
            lower_case: am.is_present("lower_case"),
            upper_case: am.is_present("upper_case"),
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
            word.push(if conf.lower_case {
                b.to_ascii_lowercase()
            } else if conf.upper_case {
                b.to_ascii_uppercase()
            } else {
                b
            });
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
