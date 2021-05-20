import java.util.*;

public class RandomStringGenerator {
    private final Random random = new Random();
    private final List<Integer> randomInts = new ArrayList<>();
    private final List<String> randomString = new ArrayList<>();

    public List<String> generateRandomString(int length, boolean upperCase) {
        for (int x = 0; x < length; x++) {
            int nextInt = random.nextInt(26) + 1;
            randomInts.add(nextInt);
        }
        bubbleSort();
        alphabetize(upperCase);
        return randomString;
    }

    private void bubbleSort() {
        int length = randomInts.size();
        int storageInt;
        for (int x = 0; x < length; x++) {
            for (int y = 1; y < (length - x); y++) {
                if (randomInts.get(y - 1) > randomInts.get(y)) {
                    storageInt = randomInts.get(y-1);
                    randomInts.set(y-1, randomInts.get(y));
                    randomInts.set(y, storageInt);
                }
            }
        }
    }

    private void alphabetize(boolean upperCase) {
        int conversionNumber = 96; //Start at lower case ASCII
        if (upperCase){
            conversionNumber = 64;
        }

        for (int randomNumber : randomInts) {
            randomString.add(String.valueOf((char)(randomNumber + conversionNumber)));
        }
    }

    public static void main(String[] args) {
        RandomStringGenerator rsg = new RandomStringGenerator();
        System.out.println(rsg.generateRandomString(1, false));
    }
}
