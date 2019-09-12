package fish.eyebrow.gman.casing;

public class SnakeCaseFormat extends AbstractFormat {

    public static String format(final String text) {
        try {
            return (firstWord ? "" : "_") + removeCommas(text.toLowerCase());
        } finally {
            firstWord = false;
        }
    }
}
