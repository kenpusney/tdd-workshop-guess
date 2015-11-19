package ns.tw.guess;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.Random;
import java.util.Set;

import static java.lang.Integer.parseInt;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NumberGeneratorTest {

    private NumberGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new NumberGenerator(new Random());
    }

    @Test
    public void should_generate_a_number() throws Exception {

        String generated = generator.generate();

        try {
            parseInt(generated);
        } catch (NumberFormatException e) {
            fail("Not a number");
        }
    }

    @Test
    public void should_generate_a_string_with_length_4() throws Exception {

        String generated = generator.generate();

        assertThat(generated.length(), is(4));
    }

    @Test
    public void should_generate_a_number_with_different_digits() throws Exception {

        String generated = generator.generate();

        for (int index = 0; index < generated.length(); index++) {
            assertThat(generated.indexOf(generated.charAt(index)),
                    is(generated.lastIndexOf(generated.charAt(index))));
        }
    }

    @Test
    public void should_generated_a_number_randomly() throws Exception {

        String first = generator.generate();
        String second = generator.generate();
        String third = generator.generate();


        assertThat(setOf(first, second, third).size(), is(3));
    }

    private Set<String> setOf(String... strings) {
        Set<String> results = new HashSet<>();
        for (String string : strings) {
            results.add(string);
        }
        return results;
    }
}