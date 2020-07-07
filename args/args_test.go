package args

import (
	"testing"
)

func TestDelimiterTransformation(t *testing.T) {
	setup()
	*WordCount = 2
	*delimiter = "-"
	word := "hello"

	ApplyArgs(&word)

	assertEqual(t, "hello-", word)
}

func TestCapitalisationTransformation(t *testing.T) {
	setup()
	*capitalise = true
	word := "oliver"

	ApplyArgs(&word)

	assertEqual(t, "Oliver", word)
}

func TestRemovingCapitalisation(t *testing.T) {
	setup()
	word := "Candi"

	ApplyArgs(&word)

	assertEqual(t, "candi", word)
}

func TestUpperCasing(t *testing.T) {
	setup()
	*upperCase = true
	word := "bunny"

	ApplyArgs(&word)

	assertEqual(t, "BUNNY", word)
}

func TestPrefix(t *testing.T) {
	setup()
	*WordCount = 2
	*prefix = "$ "
	word0 := "Alfie"
	word1 := "boy"

	ApplyArgs(&word0)
	ApplyArgs(&word1)

	assertEqual(t, "$ alfie ", word0)
	assertEqual(t, "boy", word1)
}

func TestSuffix(t *testing.T) {
	setup()
	*WordCount = 2
	*suffix = "!"
	word0 := "big"
	word1 := "wuv"

	ApplyArgs(&word0)
	ApplyArgs(&word1)

	assertEqual(t, "big ", word0)
	assertEqual(t, "wuv!", word1)
}

func TestRemoveApostrophes(t *testing.T) {
	setup()
	*removeApostrophes = true
	word := "lari's"

	ApplyArgs(&word)

	assertEqual(t, "laris", word)
}

func TestCapitalisingSequence(t *testing.T) {
	setup()
	*capitaliseSequence = true
	word0 := "hello"
	word1 := "World"

	ApplyArgs(&word0)
	ApplyArgs(&word1)

	assertEqual(t, "Hello", word0)
	assertEqual(t, "world", word1)
}

func TestCapitalisingSequenceIgnoresPrefix(t *testing.T) {
	setup()
	*prefix = ">"
	*capitaliseSequence = true
	word0 := "hello"
	word1 := "world"

	ApplyArgs(&word0)
	ApplyArgs(&word1)

	assertEqual(t, ">Hello", word0)
	assertEqual(t, "world", word1)
}

func setup() {
	*WordCount = 0
	*delimiter = " "
	*capitalise = false
	*upperCase = false
	*prefix = ""
	*suffix = ""
	*removeApostrophes = false
	*capitaliseSequence = false
	seenCount = 0
}

func assertEqual(t *testing.T, expected, actual interface{}) {
	if expected != actual {
		t.Errorf("actual {%s} does not equal expected {%s}", actual, expected)
	}
}
