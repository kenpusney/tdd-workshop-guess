package ns.tw.guess;

public class CompareNumber {

    public String compare(String generated, String guessed) {
        int aCount = 0;
        int containedCount = 0;
        for (int index = 0; index < generated.length(); index++) {
            if (generated.charAt(index) == guessed.charAt(index)) {
                aCount++;
            }
            if (guessed.indexOf(generated.charAt(index)) != -1) {
                containedCount++;
            }
        }
        return String.format("%dA%dB", aCount, containedCount - aCount);
    }
}
