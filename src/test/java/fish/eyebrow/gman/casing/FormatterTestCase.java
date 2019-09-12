package fish.eyebrow.gman.casing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormatterTestCase {

    private String[] words;

    private String transformed;


    @BeforeEach
    void setUp() {
        words = new String[] { "This", "isn't", "the", "worst" };
    }


    @AfterEach
    void tearDown() {
        Formatter.reset();
    }


    @Test
    void pascalCase() {
        callFormatterWithWordsNoDelimiter(false);

        assertThat(transformed).isEqualTo("ThisIsntTheWorst");
    }


    @Test
    void camelCase() {
        callFormatterWithWordsNoDelimiter(true);

        assertThat(transformed).isEqualTo("thisIsntTheWorst");
    }


    @Test
    void snakeCase() {
        callFormatterWithWords("_");

        assertThat(transformed).isEqualTo("this_isnt_the_worst");
    }


    @Test
    void kebabCase() {
        callFormatterWithWords("-");

        assertThat(transformed).isEqualTo("this-isnt-the-worst");
    }


    private void callFormatterWithWordsNoDelimiter(final boolean firstLower) {
        final StringBuilder transformedBuilder = new StringBuilder();

        for (final String word : words) {
            transformedBuilder.append(Formatter.format(word, firstLower, false));
        }

        transformed = transformedBuilder.toString();
    }


    private void callFormatterWithWords(final String delimiter) {
        final StringBuilder transformedBuilder = new StringBuilder();

        for (final String word : words) {
            transformedBuilder.append(Formatter.format(word, false, true, delimiter));
        }

        transformed = transformedBuilder.toString();
    }
}
