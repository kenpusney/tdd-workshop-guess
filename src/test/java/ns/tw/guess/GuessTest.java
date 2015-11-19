package ns.tw.guess;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class GuessTest {

    private Guess guess;
    private Random random;
    private NumberGenerator generator;
    private CompareNumber compareNumber;

    @Before
    public void setUp() throws Exception {
        random = mock(Random.class);
        generator = new NumberGenerator(random);
        compareNumber = new CompareNumber();
        guess = new Guess(generator, compareNumber);

    }

    @Test
    public void should_guess_successfully_when_guessed_match_generated() throws Exception {
        when(random.nextInt(10)).thenReturn(1, 2, 3, 4);

        String tip = guess.guess("1234");

        assertThat(tip, is("4A0B"));
    }

    @Test
    public void should_guess_fail_when_guessed_mismatch_generated() throws Exception {
        when(random.nextInt(10)).thenReturn(1, 2, 3, 4);

        String tip = guess.guess("4321");

        assertThat(tip, not("4A0B"));
    }

    @Test
    public void should_fail_when_user_input_less_than_4_digits() throws Exception {
        String tip = guess.guess("123");

        assertNull(tip);
        verify(random, never()).nextInt(10);
    }

    @Test
    public void should_fail_when_user_input_is_not_a_number() throws Exception {
        String tip = guess.guess("abcd");

        assertNull(tip);
        verify(random, never()).nextInt(10);
    }
}
