package fish.eyebrow.gman;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class GmanWordBuilder {

    private static final Random random = new Random();


    public static String build(final List<String> lines) {
        final int bound = lines.size();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < Application.getWords(); i++) {
            final Function<String, String> format = Application.getCasing().getFormat();
            final String transformed = format.apply(lines.get(random.nextInt(bound)));
            word.append(transformed);
        }

        word.insert(0, Application.getPrefix());
        word.insert(word.length(), Application.getSuffix());

        return word.toString();
    }
}
