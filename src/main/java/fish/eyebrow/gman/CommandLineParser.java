package fish.eyebrow.gman;

import org.apache.commons.cli.CommandLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CommandLineParser {

    private static final Logger logger = LoggerFactory.getLogger(CommandLineParser.class);


    static void parse(final CommandLine parse) {
        parseCasing(parse);
        parseWords(parse);
    }


    private static void parseCasing(final CommandLine parse) {
        final String casingOptionShort = GmanOptions.CASING.getOpt();
        if (parse.hasOption(casingOptionShort)) {
            try {
                final int optionValue = Integer.parseInt(parse.getOptionValue(casingOptionShort));
                Casing.ofOrdinal(optionValue).ifPresent(Application::setCasing);
            }
            catch (final NumberFormatException e) {
                logger.warn("Value given [{}] was not a number!", parse.getOptionValue(casingOptionShort));
            }
        }
    }


    private static void parseWords(final CommandLine parse) {
        final String wordsOptionShort = GmanOptions.WORDS.getOpt();
        if (parse.hasOption(wordsOptionShort)) {
            try {
                final int optionValue = Integer.parseInt(parse.getOptionValue(wordsOptionShort));
                Application.setWords(optionValue);
            }
            catch (final NumberFormatException e) {
                logger.warn("Value given [{}] was not a number!", parse.getOptionValue(wordsOptionShort));
            }
        }
    }
}
