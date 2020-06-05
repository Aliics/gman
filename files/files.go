package files

import (
	"math/rand"
	"os"
	"time"
)

const (
	wordsFilePath   string = "/etc/dictionaries-common/words"
	maxFileReadSize int    = 615100 * 6
)

var generatedRandomSeed bool

type WordsFile struct {
	file  *os.File
	lines []string
}

func (w WordsFile) Close() {
	err := w.file.Close()
	if err != nil {
		panic("could not close file " + wordsFilePath)
	}
}

func (w WordsFile) RandomWord() string {
	if !generatedRandomSeed {
		rand.Seed(time.Now().UnixNano())
		generatedRandomSeed = true
	}

	randomLine := rand.Intn(len(w.lines))
	return w.lines[randomLine]
}

func OpenWordsFile() WordsFile {
	file, err := os.Open(wordsFilePath)
	if err != nil {
		panic("could not open " + wordsFilePath)
	}

	fileData, fileLength := readFile(file)
	lines := make([]string, len(fileData))
	var word string
	var count int
	for i, v := range fileData {
		if i == fileLength {
			lines = lines[:count]
			break
		} else if v == '\n' {
			lines[count] = word
			word = ""
			count++
		} else {
			word += string(v)
		}
	}

	return WordsFile{file, lines}
}

func readFile(file *os.File) ([]byte, int) {
	fileData := make([]byte, maxFileReadSize)

	length, err := file.Read(fileData)
	if err != nil {
		panic("could not read from " + wordsFilePath)
	}

	return fileData, length
}
