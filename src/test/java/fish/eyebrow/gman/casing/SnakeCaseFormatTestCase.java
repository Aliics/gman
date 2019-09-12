package fish.eyebrow.gman.casing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SnakeCaseFormatTestCase {

    @Test
    void snakeCasing() {
        final String[] words = { "this", "is", "dank" };
        final StringBuilder stringBuilder = new StringBuilder();

        whenSnakeCaseFormattedTwice(words, stringBuilder);

        assertThat(stringBuilder.toString()).isEqualTo("this_is_dankthis_is_dank");
    }


    private void whenSnakeCaseFormattedTwice(final String[] words, final StringBuilder stringBuilder) {
        for (final String word : words) {
            stringBuilder.append(SnakeCaseFormat.format(word));
        }

        AbstractFormat.reset();

        for (final String word : words) {
            stringBuilder.append(SnakeCaseFormat.format(word));
        }

        AbstractFormat.reset();
    }
}