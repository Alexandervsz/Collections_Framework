import java.util.*;

public class RandomStringGenerator {
    private final Random random;
    private final Sortable sortable;

    public RandomStringGenerator(Sortable.Mode mode) {
        random = new Random();
        sortable = new Sortable(mode);
    }

    public List<String> generateRandomString(int length, boolean upperCase) {
        for (int x = 0; x < length; x++) {
            int nextInt = random.nextInt(26) + 1;
            sortable.addIntTo(nextInt);
        }
        bubbleSort();
        alphabetize(upperCase);
        return switch (sortable.getMode()) {
            case LISTBASED -> sortable.getRandomStringList();
            case LINKEDLISTBASED -> sortable.getRandomStringLinkedList();
        };
    }

    private void bubbleSort() {
        int length = sortable.getRandomIntSize();
        int storageInt;
        for (int x = 0; x < length; x++) {
            for (int y = 1; y < (length - x); y++) {
                if (sortable.getIntAt(y - 1) > sortable.getIntAt(y)) {
                    storageInt = sortable.getIntAt(y - 1);
                    sortable.setIntTo(y - 1, sortable.getIntAt(y));
                    sortable.setIntTo(y, storageInt);
                }
            }
        }
    }

    private void alphabetize(boolean upperCase) {
        int conversionNumber = 96; //Start at lower case ASCII
        if (upperCase) {
            conversionNumber = 64;
        }
        List<Integer> randomIntsList;
        LinkedList<Integer> randomIntsLinkedList;
        switch (sortable.getMode()) {
            case LISTBASED -> {
                randomIntsList = sortable.getRandomIntsList();
                for (int randomNumber : randomIntsList) {
                    sortable.addStringTo(String.valueOf((char) (randomNumber + conversionNumber)));
                }
            }
            case LINKEDLISTBASED -> {
                randomIntsLinkedList = sortable.getRandomIntsLinkedList();
                for (int randomNumber : randomIntsLinkedList) {
                    sortable.addStringTo(String.valueOf((char) (randomNumber + conversionNumber)));
                }
            }
        }
    }

    public static void main(String[] args) {
        RandomStringGenerator rsg = new RandomStringGenerator(Sortable.Mode.LINKEDLISTBASED);
        System.out.println(rsg.generateRandomString(1, false));
    }
}
