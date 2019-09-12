package fish.eyebrow.gman.casing;

abstract class AbstractFormat {

    static String removeCommas(final String text) {
        return text.replaceAll("'", "");
    }


    static String capitalize(final String text) {
        return Character.toUpperCase(text.charAt(0)) + text.substring(1);
    }
}
