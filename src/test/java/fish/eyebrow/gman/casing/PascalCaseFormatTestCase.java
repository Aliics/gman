package fish.eyebrow.gman.casing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PascalCaseFormatTestCase {

    @Test
    void formatsToExpected() {
        final String foobar = "foobar";

        final String format = PascalCaseFormat.format(foobar);

        assertThat(format).isEqualTo("Foobar");
    }
}