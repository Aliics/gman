# gman
**G**ive **M**e **A** **N**ame.

Need a name for something? Maybe you just need some random text as a placeholder?
Luckily, **gman** can do that and very quickly! 

# Performance
As much as you care about a name generator being fast, I've decided to make sure it is
performant.

Originally **gman** was written in *Lua*, but I decided to switch to a slightly faster
language that I am very familiar with *Java*. However, I decided to yet again rewrite
**gman** due to the fact that *Java* is not the most suited for CLI applications.

**Gman** is currently written in **Go**, boasts speeds up to **4x** my previous 
implementation. On my laptop I can generate **1,000,000** words in around **1 second**.
