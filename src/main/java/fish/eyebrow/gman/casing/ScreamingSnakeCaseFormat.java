package fish.eyebrow.gman.casing;

public class ScreamingSnakeCaseFormat extends AbstractFormat {

    public static String format(final String text) {
        try {
            return (firstWord ? "" : "_") + removeCommas(text.toUpperCase());
        } finally {
            firstWord = false;
        }
    }
}
