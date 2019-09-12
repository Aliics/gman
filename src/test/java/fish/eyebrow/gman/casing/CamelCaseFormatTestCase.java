package fish.eyebrow.gman.casing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CamelCaseFormatTestCase {

    @Test
    void camelCases() {
        final String[] words = { "this", "is", "dank" };
        final StringBuilder stringBuilder = new StringBuilder();

        whenCamelCaseFormattedTwice(words, stringBuilder);

        assertThat(stringBuilder.toString()).isEqualTo("thisIsDankthisIsDank");
    }


    private void whenCamelCaseFormattedTwice(final String[] words, final StringBuilder stringBuilder) {
        for (final String word : words) {
            stringBuilder.append(CamelCaseFormat.format(word));
        }

        AbstractFormat.reset();

        for (final String word : words) {
            stringBuilder.append(CamelCaseFormat.format(word));
        }
    }
}