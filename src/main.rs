use tokio::io::AsyncReadExt;
use tokio::fs::File;
use rand::Rng;

#[tokio::main]
async fn main() -> std::io::Result<()> {
    let mut f = File::open("/etc/dictionaries-common/words").await?;
    let mut data = Vec::new();
    f.read_to_end(&mut data).await?;
    let words = group_words(data);
    let line: usize = rand::thread_rng().gen_range(0..words.len());
    println!("{}", words[line]);
    Ok(())
}

fn group_words(bytes: Vec<u8>) -> Vec<String> {
    let mut word = String::new();
    let mut words = Vec::new();
    for b in bytes {
        if b as char == '\n' {
            words.push(word);
            word = String::new();
        }
        word.push(b as char);
    }
    words
}
