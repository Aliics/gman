 use tokio::io::AsyncReadExt;
use tokio::task::spawn;
use tokio::fs::File;
use rand::Rng;

#[tokio::main]
async fn main() -> std::io::Result<()> {
    let count: i32 = 1_000_000;
    let mut f = File::open("/etc/dictionaries-common/words").await?;
    let mut data = Vec::new();
    f.read_to_end(&mut data).await?;
    let words = group_words(data);
    for _ in 0..count {
        let line: usize = rand::thread_rng().gen_range(0..words.len());
        let word = words[line].clone();
        spawn(async move {
            println!("{}", word);
        });
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
