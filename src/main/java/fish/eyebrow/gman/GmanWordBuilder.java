package fish.eyebrow.gman;

import java.util.List;
import java.util.Random;

public class GmanWordBuilder {

    private static final Random random = new Random();


    public static String build(final List<String> lines) {
        final int bound = lines.size();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < Application.getWords(); i++) {
            word.append(lines.get(random.nextInt(bound)));
        }

        word.insert(0, Application.getPrefix());
        word.insert(word.length(), Application.getSuffix());

        return word.toString();
    }
}
