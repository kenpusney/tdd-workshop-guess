package ns.tw.guess;

import java.util.HashSet;
import java.util.Random;

public class NumberGenerator {
    private Random random;

    public NumberGenerator(Random random) {
        this.random = random;
    }

    public String generate() {
        HashSet<Integer> digits = new HashSet<>();
        while(digits.size() < 4) {
            digits.add(random.nextInt(10));
        }
        String generated = "";
        for(int digit: digits) {
            generated += digit;
        }
        return generated;
    }
}
