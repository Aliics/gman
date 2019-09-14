package fish.eyebrow.gman;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

import fish.eyebrow.gman.casing.Casing;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;

@ExtendWith(MockitoExtension.class)
class CommandLineParserTestCase {

    @Mock
    private static PrintStream outputStreamMock;

    private static final DefaultParser parser = new DefaultParser();

    private static final Options options = Application.getOptions();


    @BeforeEach
    void setUp() {
        GmanOptions.setup();
    }


    @AfterEach
    void tearDown() {
        Application.setCasing(Casing.PASCAL_CASE);
        Application.setWords(2);
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


    @Test
    void assigningValidWords() throws ParseException {
        final String[] args = { "-w", "44" };

        CommandLineParser.parse(parser.parse(options, args));

        assertThat(Application.getWords()).isEqualTo(44);
    }


    @Test
    void assigningInvalidWords() throws ParseException {
        final String[] args = { "-w", "foo" };

        CommandLineParser.parse(parser.parse(options, args));

        assertThat(Application.getWords()).isEqualTo(2);
    }


    @Test
    void assigningPrefix() throws ParseException {
        final String[] args = { "-p", "foo" };

        CommandLineParser.parse(parser.parse(options, args));

        assertThat(Application.getPrefix()).isEqualTo("foo");
    }


    @Test
    void assignSuffix() throws ParseException {
        final String[] args = { "-s", "foo" };

        CommandLineParser.parse(parser.parse(options, args));

        assertThat(Application.getSuffix()).isEqualTo("foo");
    }

    @Test
    void displayHelp() throws ParseException {
        final String[] args = { "-h" };
        System.setOut(outputStreamMock);

        CommandLineParser.parse(parser.parse(options, args));

        verify(outputStreamMock).write(any(byte[].class), anyInt(), anyInt());
    }
}