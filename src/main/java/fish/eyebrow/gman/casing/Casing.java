package fish.eyebrow.gman.casing;

import java.util.Optional;
import java.util.function.Function;

public enum Casing {
    PASCAL_CASE(0, text -> Formatter.format(text, false, false)),
    CAMEL_CASE(1, text -> Formatter.format(text, true, false)),
    SNAKE_CASE(2, text -> Formatter.format(text, false, true, "_")),
    SCREAMING_SNAKE_CASE(3, text -> Formatter.format(text, false, true, "_").toUpperCase()),
    KEBAB_CASE(4, text -> Formatter.format(text, false, true, "-")),
    SCREAMING_KEBAB_CASE(5, text -> Formatter.format(text, false, true, "-").toUpperCase()),
    SPACED(6, text -> Formatter.format(text, false, true, " ")),
    SCREAMING_SPACED(7, text -> Formatter.format(text, false, true, " ").toUpperCase());

    private final int ordinal;

    private final Function<String, String> format;


    Casing(final int ordinal, final Function<String, String> format) {
        this.ordinal = ordinal;
        this.format = format;
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


    public Function<String, String> getFormat() {
        return format;
    }
}
