package fish.eyebrow.gman;

import java.util.Optional;

enum Casing {
    PASCAL_CASE(0),
    CAMEL_CASE(1),
    SNAKE_CASE(2),
    SCREAMING_SNAKE_CASE(3),
    KEBAB_CASE(4),
    SPACED(5);

    private final int ordinal;


    Casing(final int ordinal) {
        this.ordinal = ordinal;
    }


    public static Optional<Casing> ofOrdinal(final int ordinal) {
        Casing found = null;
        for (final Casing casing : values()) {
            if (casing.ordinal == ordinal) {
                found = casing;
            }
        }

        return Optional.ofNullable(found);
    }


    public int getOrdinal() {
        return ordinal;
    }
}
