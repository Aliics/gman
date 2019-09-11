package fish.eyebrow.gman;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class GmanWordBuilderTestCase {

    private List<String> lines;

    private String word;


    @Test
    void buildingAWord() throws IOException {
        givenLinesFromWordsFile();

        whenBuildCalled();

        assertThat(word).isNotNull();
    }


    @Test
    void appendingSuffixAndPrefix() throws IOException {
        givenLinesFromWordsFile();
        Application.setPrefix("foo");
        Application.setSuffix("bar");

        whenBuildCalled();

        assertThat(word).contains("foo").contains("bar");
    }


    private void givenLinesFromWordsFile() throws IOException {
        lines = Files.readAllLines(Paths.get(ClassLoader.getSystemResource("words").getPath()));
    }


    private void whenBuildCalled() {
        word = GmanWordBuilder.build(lines);
    }
}
