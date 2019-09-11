package fish.eyebrow.gman.casing;

abstract class AbstractFormat {

    static String removeCommas(final String text) {
        return text.replaceAll("'", "");
    }


    static String capitalize(final String text) {
        return text.replace(text.charAt(0), Character.toUpperCase(text.charAt(0)));
    }
}
