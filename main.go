package main

import (
	"./args"
	"./files"
	"fmt"
	"strings"
)

func main() {
	args.ParseArgs()

	var output strings.Builder

	wordsFile := files.OpenWordsFile()
	defer wordsFile.Close()

	for i := 0; i < *args.WordCount; i++ {
		word := wordsFile.RandomWord()
		args.ApplyArgs(&word)

		output.WriteString(word)
	}

	fmt.Println(output.String())
}
