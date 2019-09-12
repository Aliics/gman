package fish.eyebrow.gman.casing;

public class CamelCaseFormat extends AbstractFormat {

    public static String format(final String text) {
        try {
            final String transformed = removeCommas(text.toLowerCase());
            return firstWord ? transformed : capitalize(transformed);
        }
        finally {
            firstWord = false;
        }
    }
}
