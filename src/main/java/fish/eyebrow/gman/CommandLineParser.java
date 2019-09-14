package fish.eyebrow.gman;

import fish.eyebrow.gman.casing.Casing;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CommandLineParser {

    private static final Logger logger = LoggerFactory.getLogger(CommandLineParser.class);

    private static final HelpFormatter helpFormatter = new HelpFormatter();

    private static final String GMAN_OPTIONS_SYNTAX = "gman [OPTIONS]";


    static void parse(final CommandLine parse) {
        parseCasing(parse);
        parseWords(parse);
        parsePrefix(parse);
        parseSuffix(parse);
        parseHelp(parse);
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


    private static void parsePrefix(final CommandLine parse) {
        final String prefixOptionShort = GmanOptions.PREFIX.getOpt();
        if (parse.hasOption(prefixOptionShort)) {
            final String optionValue = parse.getOptionValue(prefixOptionShort);
            Application.setPrefix(optionValue);
        }
    }


    private static void parseSuffix(final CommandLine parse) {
        final String suffixOptionShort = GmanOptions.SUFFIX.getOpt();
        if (parse.hasOption(suffixOptionShort)) {
            final String optionValue = parse.getOptionValue(suffixOptionShort);
            Application.setSuffix(optionValue);
        }
    }


    private static void parseHelp(final CommandLine parse) {
        if (parse.hasOption(GmanOptions.HELP.getOpt())) {
            helpFormatter.printHelp(GMAN_OPTIONS_SYNTAX, Application.getOptions());
        }
    }
}
