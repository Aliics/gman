package fish.eyebrow.gman;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Test;

class CommandLineParserTestCase {

    private static final BasicParser parser = new BasicParser();

    private static final Options options = new Options();


    @Test
    void assigningValidCasing() throws ParseException {
        final String[] args = { "-c", "2" };

        CommandLineParser.parse(parser.parse(options, args));

        assertThat(Application.casing).isEqualTo(2);
    }
}