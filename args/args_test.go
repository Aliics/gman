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

func setup() {
	*WordCount = 0
	*delimiter = " "
	*capitalise = false
	*upperCase = false
	*prefix = ""
	*suffix = ""
	seenCount = 0
}

func assertEqual(t *testing.T, expected interface{}, actual interface{}) {
	if expected != actual {
		t.Errorf("actual {%s} does not equal expected {%s}", actual, expected)
	}
}
