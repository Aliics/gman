# gman
**G**ive **M**e **A** **N**ame.

Need a name for something? Maybe you just need some random text as a placeholder?
Luckily, **gman** can do that and very quickly! 

# Usage
### Prerequisites
- make
- go
- a command line

### Compile me!
I have written a pretty basic *Makefile* to do the "heavy-lifting" for you... not that
*go*'s CLI is that difficult to use.

Run the *Makefile*:
```shell script
$ make
```
That should create a binary in a `./build` called `gman`.

Run the *compiled binary*:
```shell script
$ ./build/gman
```
or
```shell script
$ exec build/gman
```

For any of the flags for custom formatting, give the program the `-help` flag.

# Performance
As much as you care about a name generator being fast, I've decided to make sure it is
performant.

Originally **gman** was written in *Lua*, but I decided to switch to a slightly faster
language that I am very familiar with *Java*. However, I decided to yet again rewrite
**gman** due to the fact that *Java* is not the most suited for CLI applications.

**Gman** is currently written in **Go**, boasts speeds up to **4x** my previous 
implementation. On my laptop I can generate **1,000,000** words in around **1 second**.
