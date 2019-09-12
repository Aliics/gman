package fish.eyebrow.gman.casing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ScreamingSnakeCaseFormatTestCase {
    @Test
    void screamingSnakeCasing() {
        final String[] words = { "this", "is", "dank" };
        final StringBuilder stringBuilder = new StringBuilder();

        whenScreamingSnakeCaseFormattedTwice(words, stringBuilder);

        assertThat(stringBuilder.toString()).isEqualTo("THIS_IS_DANKTHIS_IS_DANK");
    }


    private void whenScreamingSnakeCaseFormattedTwice(final String[] words, final StringBuilder stringBuilder) {
        for (final String word : words) {
            stringBuilder.append(ScreamingSnakeCaseFormat.format(word));
        }

        AbstractFormat.reset();

        for (final String word : words) {
            stringBuilder.append(ScreamingSnakeCaseFormat.format(word));
        }

        AbstractFormat.reset();
    }
}