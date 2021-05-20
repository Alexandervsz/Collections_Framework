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
            sortable.addInt(nextInt);
        }
        bubbleSort();
        alphabetize(upperCase);
        return switch (sortable.getMode()) {
            case LISTBASED -> sortable.getStringList();
            case LINKEDLISTBASED -> sortable.getStringLinkedList();
        };
    }

    private void bubbleSort() {
        int length = sortable.getIntListSize();
        int storageInt;
        for (int x = 0; x < length; x++) {
            for (int y = 1; y < (length - x); y++) {
                if (sortable.getInt(y - 1) > sortable.getInt(y)) {
                    storageInt = sortable.getInt(y - 1);
                    sortable.setInt(y - 1, sortable.getInt(y));
                    sortable.setInt(y, storageInt);
                }
            }
        }
    }

    private void alphabetize(boolean upperCase) {
        int conversionNumber = 96; //Start at lower case ASCII
        if (upperCase) {
            conversionNumber = 64;
        }
        convertListToAlpha(conversionNumber);

    }

    private void convertListToAlpha(int conversionNumber){
        for (int randomNumber: sortable.getList()){
            sortable.addString(String.valueOf((char) (randomNumber + conversionNumber)));
        }
    }

    public static void main(String[] args) {
        RandomStringGenerator rsg = new RandomStringGenerator(Sortable.Mode.LINKEDLISTBASED);
        System.out.println(rsg.generateRandomString(1, false));
    }
}
