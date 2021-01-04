# gman

**G**ive **M**e **A** **N**ame.

Need a name for something? Maybe you just need some random text as a placeholder?
Luckily, `gman` can do that and very quickly! 

# history

`gman` was a small script originally written in [Lua](https://lua.org/).
This was fine, but I got hung up the performance and wanted to implement it in
a language that I actually use.

So, I then switched over to the language I use for work, 
[Java](https://openjdk.net/). This was far faster, at runtime, than the `Lua`
version. But this version was pretty short lived because of the verbosity and
*JVM* cold start overhead.

After using [Go](https://golang.org/) for a short amount of time I really wanted
to reimplement this project yet again. This boasted the best performance yet,
and I was quite happy with the language. I felt like this was finally something
I could put to rest.

As you may have guessed, the story didn't end with the `Go` implementation.
[Rust](https://rust-lang.org/) made it's way back into my life after 
experiencing excessive `interface{}`, `reflect.ValueOf(...)`, and `err != nil`
usages. I really missed `Rust`.

Additionally the `Rust` version is at least on-par, if not faster, than the `Go`
version. I also gained the countless safeties of working in `Rust` that were
previously missing.
