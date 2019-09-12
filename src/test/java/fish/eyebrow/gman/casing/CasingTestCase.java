package fish.eyebrow.gman.casing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Optional;

class CasingTestCase {

    @Test
    void validOrdinal() {
        final int casing = 4;

        final Optional<Casing> found = Casing.ofOrdinal(casing);

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get()).isEqualTo(Casing.KEBAB_CASE);
    }


    @Test
    void invalidOrdinal() {
        final int casing = 12;

        final Optional<Casing> found = Casing.ofOrdinal(casing);

        assertThat(found.isPresent()).isFalse();
    }
}
