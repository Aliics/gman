package fish.eyebrow.gman.casing;

public class PascalCaseFormat extends AbstractFormat {

    public static String format(final String text) {
        return capitalize(text.toLowerCase());
    }
}
