package fish.eyebrow.gman;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static final BasicParser parser = new BasicParser();

    private static final Options options = new Options();

    static Casing casing = Casing.PASCAL_CASE;

    static String prefix = "";

    static String suffix = "";

    static int words = 2;


    public static void main(final String... args) {
        options.addOption("c", "casing", true, "The casing to dictate how your word is formatted.");
        options.addOption("p", "prefix", true, "Sequence of characters prepended to your word.");
        options.addOption("s", "suffix", true, "Sequence of characters appended to your word.");
        options.addOption("w", "words", true, "Number of word to be added to your name.");

        try {
            CommandLineParser.parse(parser.parse(options, args));
        }
        catch (final ParseException e) {
            logger.warn("Exception occurred parsing args [{}] with options [{}]", args, options);
        }
    }
}
