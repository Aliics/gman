package fish.eyebrow.gman.casing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SpacedFormatTestCase {

    @Test
    void snakeCasing() {
        final String[] words = { "this", "is", "dank" };
        final StringBuilder stringBuilder = new StringBuilder();

        whenSpacedCaseFormattedTwice(words, stringBuilder);

        assertThat(stringBuilder.toString()).isEqualTo("this is dankthis is dank");
    }


    private void whenSpacedCaseFormattedTwice(final String[] words, final StringBuilder stringBuilder) {
        for (final String word : words) {
            stringBuilder.append(SpacedFormat.format(word));
        }

        AbstractFormat.reset();

        for (final String word : words) {
            stringBuilder.append(SpacedFormat.format(word));
        }

        AbstractFormat.reset();
    }
}