package fish.eyebrow.gman.casing;

import java.util.Optional;
import java.util.function.Function;

public enum Casing {
    PASCAL_CASE(0, PascalCaseFormat::format),
    CAMEL_CASE(1, CamelCaseFormat::format),
    SNAKE_CASE(2, PascalCaseFormat::format),
    SCREAMING_SNAKE_CASE(3, PascalCaseFormat::format),
    KEBAB_CASE(4, PascalCaseFormat::format),
    SPACED(5, PascalCaseFormat::format);

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
