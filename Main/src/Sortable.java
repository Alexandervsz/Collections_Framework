import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sortable {
    enum Mode {
        LISTBASED,
        LINKEDLISTBASED
    }

    private List<Integer> intList;
    private List<String> stringList;
    private LinkedList<Integer> intLinkedList;
    private LinkedList<String> stringLinkedList;
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

    public List<Integer> getIntList() {
        return intList;
    }

    public LinkedList<Integer> getIntLinkedList() {
        return intLinkedList;
    }


    public List<String> getStringList() {
        return stringList;
    }

    public LinkedList<String> getStringLinkedList() {
        return stringLinkedList;
    }

    private void initialiseListBased() {
        intList = new ArrayList<>();
        stringList = new ArrayList<>();
    }

    private void initialiseLinkedListBased() {
        intLinkedList = new LinkedList<>();
        stringLinkedList = new LinkedList<>();
    }

    public int getInt(int location) {
        return switch (mode) {
            case LISTBASED -> intList.get(location);
            case LINKEDLISTBASED -> intLinkedList.get(location);
        };
    }

    public void addInt(int element) {
        switch (mode) {
            case LISTBASED -> intList.add(element);
            case LINKEDLISTBASED -> intLinkedList.addLast(element);
        }
    }

    public void setInt(int location, int element) {
        switch (mode) {
            case LISTBASED -> intList.set(location, element);
            case LINKEDLISTBASED -> intLinkedList.set(location, element);
        }
    }

    public void addString(String element) {
        switch (mode) {
            case LISTBASED -> stringList.add(element);
            case LINKEDLISTBASED -> stringLinkedList.addLast(element);
        }
    }

    public int getIntListSize() {
        return switch (mode) {
            case LISTBASED -> intList.size();
            case LINKEDLISTBASED -> intLinkedList.size();
        };
    }
}
