package fish.eyebrow.gman;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandLineParserTestCase {

    private static final BasicParser parser = new BasicParser();

    private static final Options options = new Options();


    @BeforeEach
    void setUp() {
        options.addOption(GmanOptions.CASING);
        options.addOption(GmanOptions.PREFIX);
        options.addOption(GmanOptions.SUFFIX);
        options.addOption(GmanOptions.WORDS);
    }


    @AfterEach
    void tearDown() {
        Application.setCasing(Casing.PASCAL_CASE);
    }


    @Test
    void assigningValidCasing() throws ParseException {
        final String[] args = { "-c", "2" };

        CommandLineParser.parse(parser.parse(options, args));

        assertThat(Application.getCasing()).isEqualTo(Casing.SNAKE_CASE);
    }


    @Test
    void assigningInvalidCasing() throws ParseException {
        final String[] args = { "-c", "foo" };

        CommandLineParser.parse(parser.parse(options, args));

        assertThat(Application.getCasing()).isEqualTo(Casing.PASCAL_CASE);
    }


    @Test
    void assigningOutOfRangeCasing() throws ParseException {
        final String[] args = { "-c", "10" };

        CommandLineParser.parse(parser.parse(options, args));

        assertThat(Application.getCasing()).isEqualTo(Casing.PASCAL_CASE);
    }
}