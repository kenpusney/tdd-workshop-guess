package ns.tw.guess;

import static java.lang.Integer.parseInt;

public class Guess {

    final NumberGenerator generator;
    final CompareNumber compareNumber;

    public Guess(NumberGenerator generator, CompareNumber compareNumber) {
        this.generator = generator;
        this.compareNumber = compareNumber;
    }

    public String guess(String input) {
        if (input.length() == 4 && isNumber(input))
            return compareNumber.compare(generator.generate(), input);
        return null;
    }

    private boolean isNumber(String input) {
        try {
            parseInt(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
