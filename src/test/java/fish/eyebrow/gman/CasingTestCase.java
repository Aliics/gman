package fish.eyebrow.gman;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CasingTestCase {

    @Test
    void validOrdinal() {
        final int casing = 4;

        final Casing found = Casing.ofOrdinal(casing);

        assertThat(found).isEqualTo(Casing.KEBAB_CASE);
    }


    @Test
    void invalidOrdinal() {
        final int casing = 7;

        final Casing found = Casing.ofOrdinal(casing);

        assertThat(found).isNull();
    }
}