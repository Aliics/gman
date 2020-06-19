package args

import (
	"flag"
	"strings"
)

var (
	WordCount          = flag.Int("count", 1, "amount of words to generate")
	delimiter          = flag.String("delimiter", " ", "sequence of characters to separate words")
	capitalise         = flag.Bool("capital", false, "words will be capitalised")
	upperCase          = flag.Bool("upper", false, "words will be in upper case (overrides capitalisation)")
	prefix             = flag.String("prefix", "", "output will begin with")
	suffix             = flag.String("suffix", "", "output will end with")
	removeApostrophes  = flag.Bool("rm-apos", false, "remove apostrophes from words")
	capitaliseSequence = flag.Bool("cap-seq", false, "capitalse sequence of words")
	seenCount          int
)

func ParseArgs() {
	flag.Parse()
}

func ApplyArgs(word *string) {
	seenCount++
	augmented := *word

	if *upperCase {
		augmented = strings.ToUpper(augmented)
	} else {
		if *capitalise {
			augmented = strings.ToUpper(augmented[:1]) + augmented[1:]
		} else {
			augmented = strings.ToLower(augmented[:1]) + augmented[1:]
		}
	}

	if *removeApostrophes {
		augmented = strings.Replace(augmented, "'", "", 1)
	}

	if seenCount == 1 {
		if *capitaliseSequence {
			augmented = strings.ToUpper((augmented)[:1]) + augmented[1:]
		}
		augmented = *prefix + augmented
	}

	if seenCount < *WordCount {
		augmented += *delimiter
	} else {
		augmented += *suffix
	}

	*word = augmented
}
