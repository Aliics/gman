package fish.eyebrow.gman;

import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static final DefaultParser parser = new DefaultParser();

    private static final Options options = new Options();

    private static Casing casing = Casing.PASCAL_CASE;

    private static String prefix = "";

    private static String suffix = "";

    private static int words = 2;


    public static void main(final String... args) {
        options.addOption(GmanOptions.CASING);
        options.addOption(GmanOptions.PREFIX);
        options.addOption(GmanOptions.SUFFIX);
        options.addOption(GmanOptions.WORDS);

        try {
            CommandLineParser.parse(parser.parse(options, args));
        }
        catch (final ParseException e) {
            logger.warn("Exception occurred parsing args [{}] with options [{}]", args, options);
        }
    }


    static void setCasing(final Casing casing) {
        Application.casing = casing;
    }


    static Casing getCasing() {
        return casing;
    }


    static int getWords() {
        return words;
    }


    static void setWords(final int words) {
        Application.words = words;
    }
}
