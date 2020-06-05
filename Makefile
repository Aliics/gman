CC = go
OUT = build

all: clean gman

clean:
	rm -rf $(OUT)

gman:
	$(CC) build -o $(OUT)/$@

run:
	exec build/gman

test:
	$(CC) test ./...

install:
	cp build/gman /usr/local/bin/

.PHONY: clean gman run test
