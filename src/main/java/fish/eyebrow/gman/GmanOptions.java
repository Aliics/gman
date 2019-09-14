package fish.eyebrow.gman;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

class GmanOptions {

    static final Option CASING = new Option("c", "casing", true, "The casing to dictate how your word is formatted.");

    static final Option PREFIX = new Option("p", "prefix", true, "Sequence of characters prepended to your word.");

    static final Option SUFFIX = new Option("s", "suffix", true, "Sequence of characters appended to your word.");

    static final Option WORDS = new Option("w", "words", true, "Number of words used to create your name.");

    static final Option HELP = new Option("h", "help", false, "Display help information.");

    static void setup() {
        final Options options = Application.getOptions();
        options.addOption(GmanOptions.CASING);
        options.addOption(GmanOptions.PREFIX);
        options.addOption(GmanOptions.SUFFIX);
        options.addOption(GmanOptions.WORDS);
        options.addOption(GmanOptions.HELP);
    }
}
