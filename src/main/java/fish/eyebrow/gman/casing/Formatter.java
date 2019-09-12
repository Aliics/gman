package fish.eyebrow.gman.casing;

public class Formatter {

    private static boolean firstWord = true;


    private static String removeCommas(final String text) {
        return text.replaceAll("'", "");
    }


    private static String capitalize(final String text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }


    public static void reset() {
        firstWord = true;
    }


    public static String format(final String text, final boolean firstLower, final boolean ignoreCapital) {
        return format(text, firstLower, ignoreCapital, "");
    }


    public static String format(final String text, final boolean firstLower, final boolean ignoreCapital, final String delimiter) {
        try {
            final String transformed = removeCommas(text.toLowerCase());
            final String transformedDelimiter = firstWord ? "" : delimiter;
            return transformedDelimiter + (firstLower && firstWord ? transformed : (ignoreCapital ? transformed : capitalize(transformed)));
        } finally {
            firstWord = false;
        }
    }
}
