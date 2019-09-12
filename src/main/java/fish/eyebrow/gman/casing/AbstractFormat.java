package fish.eyebrow.gman.casing;

public abstract class AbstractFormat {

    static boolean firstWord = true;


    static String removeCommas(final String text) {
        return text.replaceAll("'", "");
    }


    static String capitalize(final String text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }


    public static void reset() {
        firstWord = true;
    }
}
