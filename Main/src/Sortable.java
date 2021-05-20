import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sortable {
    enum Mode {
        LISTBASED,
        LINKEDLISTBASED
    }

    private List<Integer> randomIntsList;
    private List<String> randomStringList;
    private LinkedList<Integer> randomIntsLinkedList;
    private LinkedList<String> randomStringLinkedList;
    private final Mode mode;

    public Sortable(Mode mode) {
        this.mode = mode;
        switch (mode) {
            case LISTBASED -> initialiseListBased();
            case LINKEDLISTBASED -> initialiseLinkedListBased();
        }
    }

    public Mode getMode() {
        return mode;
    }

    public List<Integer> getRandomIntsList() {
        return randomIntsList;
    }

    public LinkedList<Integer> getRandomIntsLinkedList() {
        return randomIntsLinkedList;
    }


    public List<String> getRandomStringList() {
        return randomStringList;
    }

    public LinkedList<String> getRandomStringLinkedList() {
        return randomStringLinkedList;
    }

    private void initialiseListBased() {
        randomIntsList = new ArrayList<>();
        randomStringList = new ArrayList<>();
    }

    private void initialiseLinkedListBased() {
        randomIntsLinkedList = new LinkedList<>();
        randomStringLinkedList = new LinkedList<>();
    }

    public int getInt(int location) {
        return switch (mode) {
            case LISTBASED -> randomIntsList.get(location);
            case LINKEDLISTBASED -> randomIntsLinkedList.get(location);
        };
    }

    public void addInt(int element) {
        switch (mode) {
            case LISTBASED -> randomIntsList.add(element);
            case LINKEDLISTBASED -> randomIntsLinkedList.addLast(element);
        }
    }

    public void setInt(int location, int element) {
        switch (mode) {
            case LISTBASED -> randomIntsList.set(location, element);
            case LINKEDLISTBASED -> randomIntsLinkedList.set(location, element);
        }
    }

    public void addString(String element) {
        switch (mode) {
            case LISTBASED -> randomStringList.add(element);
            case LINKEDLISTBASED -> randomStringLinkedList.addLast(element);
        }
    }

    public int getIntListSize() {
        return switch (mode) {
            case LISTBASED -> randomIntsList.size();
            case LINKEDLISTBASED -> randomIntsLinkedList.size();
        };
    }
}
