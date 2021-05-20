import java.util.*;

public class RandomStringGenerator {
    private final Random random = new Random();
    private final List<String> randomString = new ArrayList<>();

    public List<String> getRandomString(int length) {
        for (int x = 0; x < length; x++) {
            int randomNumber = random.nextInt(26) + 1;
            randomString.add(String.valueOf((char) (randomNumber + 96)));
        }
        return randomString;
    }
}
