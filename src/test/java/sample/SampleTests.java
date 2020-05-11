package sample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SampleTests {
    @Test
    void test() {
        String actual = new Sample().execute();
        assertThat(actual).isEqualTo("hello world!!");
    }
}
