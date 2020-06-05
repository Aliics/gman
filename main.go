package main

import (
	"./files"
	"fmt"
	"strings"
)

func main() {
	var output strings.Builder

	wordsFile := files.OpenWordsFile()
	defer wordsFile.Close()

	for i := 0; i < 1000000; i++ {
		output.WriteString(wordsFile.RandomWord())
	}

	fmt.Println(output.String())
}
