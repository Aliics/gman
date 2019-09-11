package fish.eyebrow.gman;

import org.apache.commons.cli.Option;

class GmanOptions {

    static final Option CASING = new Option("c", "casing", true, "The casing to dictate how your word is formatted.");

    static final Option PREFIX = new Option("p", "prefix", true, "Sequence of characters prepended to your word.");

    static final Option SUFFIX = new Option("s", "suffix", true, "Sequence of characters appended to your word.");

    static final Option WORDS = new Option("w", "words", true, "Number of word to be added to your name.");
}
