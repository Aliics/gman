package args

import (
	"flag"
	"strings"
)

var (
	WordCount         = flag.Int("count", 1, "amount of words to generate")
	delimiter         = flag.String("delimiter", " ", "sequence of characters to separate words")
	capitalise        = flag.Bool("capital", false, "words will be capitalised")
	upperCase         = flag.Bool("upper", false, "words will be in upper case")
	prefix            = flag.String("prefix", "", "output will begin with")
	suffix            = flag.String("suffix", "", "output will end with")
	removeApostrophes = flag.Bool("rm-apos", false, "remove apostrophes from words")
	seenCount         int
)

func ParseArgs() {
	flag.Parse()
}

func ApplyArgs(word *string) {
	if *upperCase {
		*word = strings.ToUpper(*word)
	} else {
		retain := (*word)[1:]
		if *capitalise {
			*word = strings.ToUpper((*word)[:1]) + retain
		} else {
			*word = strings.ToLower((*word)[:1]) + retain
		}
	}

	if *removeApostrophes {
		*word = strings.Replace(*word, "'", "", 1)
	}

	seenCount++
	if seenCount == 1 {
		*word = *prefix + *word
	}

	if seenCount < *WordCount {
		*word += *delimiter
	} else {
		*word += *suffix
	}
}
