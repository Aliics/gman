use clap::{App, Arg, ArgMatches};
use core::result;
use rand::Rng;
use std::io::{self, Read};
use std::{fs::File, num::ParseIntError};

const DICT: &str = "/etc/dictionaries-common/words";

struct Conf {
    count: i32,
    delimiter: String,
}

impl Conf {
    fn of_arg_matches(am: ArgMatches) -> result::Result<Conf, ParseIntError> {
        let count = am.value_of("count").unwrap().parse()?;
        let delimiter = am.value_of("delimiter").unwrap().to_owned();
        Ok(Conf { count, delimiter })
    }
}

fn main() -> io::Result<()> {
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
        ])
        .get_matches();
    let Conf { count, delimiter } = Conf::of_arg_matches(am).unwrap();
    let mut f = File::open(DICT)?;
    let mut data = Vec::new();
    f.read_to_end(&mut data)?;
    let words = group_words(data);
    let mut rng = rand::thread_rng();
    for i in 0..count {
        let line = rng.gen_range(0..words.len());
        let word = words[line].as_str();
        let delimiter = if i < count - 1 {
            delimiter.as_str()
        } else {
            "\n"
        };
        print!("{}{}", word, delimiter);
    }
    Ok(())
}

fn group_words(bytes: Vec<u8>) -> Vec<String> {
    let mut word = String::new();
    let mut words = Vec::new();
    for b in bytes {
        if b as char == '\n' {
            words.push(word);
            word = String::new();
        } else {
            word.push(b as char);
        }
    }
    words
}

#[cfg(test)]
mod tests {
    use crate::group_words;

    #[test]
    fn grouped() {
        let separated: Vec<u8> = vec![b'a', b'b', b'c', b'\n', b'd', b'e', b'f', b'\n'];
        let words = group_words(separated);
        assert_eq!(words, vec!["abc", "def"]);
    }
}
