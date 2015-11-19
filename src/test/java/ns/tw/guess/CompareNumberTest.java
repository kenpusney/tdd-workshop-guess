package ns.tw.guess;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CompareNumberTest {

    private CompareNumber compareNumber;

    @Before
    public void setUp() throws Exception {
        compareNumber = new CompareNumber();
    }

    @Test
    public void should_show_tip_4A0B_when_compare_1234_and_1234() throws Exception {
        String generated = "1234";
        String guessed = "1234";

        String tip = compareNumber.compare(generated, guessed);

        assertThat(tip, is("4A0B"));
    }

    @Test
    public void should_show_tip_0A0B_when_compare_1234_and_5678() throws Exception {
        String generated = "1234";
        String guessed = "5678";

        String tip = compareNumber.compare(generated, guessed);

        assertThat(tip, is("0A0B"));
    }

    @Test
    public void should_show_tip_0A4B_when_compare_1234_and_4321() throws Exception {
        String generated = "1234";
        String guessed = "4321";

        String tip = compareNumber.compare(generated, guessed);

        assertThat(tip, is("0A4B"));
    }

    @Test
    public void should_show_tip_2A2B_when_compare_1234_and_1324() throws Exception {
        String generated = "1234";
        String guessed = "1324";

        String tip = compareNumber.compare(generated, guessed);

        assertThat(tip, is("2A2B"));
    }
}