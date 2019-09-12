package fish.eyebrow.gman.casing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class KebabCaseFormatTestCase {

    @Test
    void kebabCasing() {
        final String[] words = { "this", "is", "dank" };
        final StringBuilder stringBuilder = new StringBuilder();

        whenKebabCaseFormattedTwice(words, stringBuilder);

        assertThat(stringBuilder.toString()).isEqualTo("this-is-dankthis-is-dank");
    }


    private void whenKebabCaseFormattedTwice(final String[] words, final StringBuilder stringBuilder) {
        for (final String word : words) {
            stringBuilder.append(KebabCaseFormat.format(word));
        }

        AbstractFormat.reset();

        for (final String word : words) {
            stringBuilder.append(KebabCaseFormat.format(word));
        }

        AbstractFormat.reset();
    }
}