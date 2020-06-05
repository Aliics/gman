package main

import (
	"./args"
	"./files"
	"fmt"
	"strings"
)

func main() {
	var output strings.Builder

	args.ParseArgs()

	wordsFile := files.OpenWordsFile()
	defer wordsFile.Close()

	for i := 0; i < *args.WordCount; i++ {
		word := wordsFile.RandomWord()
		args.ApplyArgs(&word)

		output.WriteString(word)
	}

	fmt.Println(output.String())
}
