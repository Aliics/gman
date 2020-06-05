CC = go
OUT = build

all: clean gman run

clean:
	rm -rf $(OUT)

gman:
	$(CC) build -o $(OUT)/$@

run:
	exec build/gman

.PHONY: clean gman
