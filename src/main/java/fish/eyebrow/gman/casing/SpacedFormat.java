package fish.eyebrow.gman.casing;

public class SpacedFormat extends AbstractFormat {

    public static String format(final String text) {
        try {
            return (firstWord ? "" : " ") + text.toLowerCase();
        } finally {
            firstWord = false;
        }
    }
}
