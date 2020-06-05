CC = go
OUT = build
DEPS = github.com/google/wire

all: clean gman run

clean:
	rm -rf $(OUT)

gman:
	$(CC) get $(DEPS)
	$(CC) build -o $(OUT)/$@

run:
	exec build/gman

.PHONY: clean gman
