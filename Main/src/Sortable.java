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

    public Mode getMode() {
        return mode;
    }

    public List<Integer> getRandomIntsList() {
        return randomIntsList;
    }

    public LinkedList<Integer> getRandomIntsLinkedList() {
        return randomIntsLinkedList;
    }

    private final Mode mode;

    public List<String> getRandomStringList() {
        return randomStringList;
    }

    public LinkedList<String> getRandomStringLinkedList() {
        return randomStringLinkedList;
    }

    public Sortable(Mode mode){
        this.mode = mode;
        switch (mode){
            case LISTBASED -> initialiseListBased();
            case LINKEDLISTBASED -> initialiseLinkedListBased();
        }
    }

    public void initialiseListBased(){
         randomIntsList = new ArrayList<>();
         randomStringList = new ArrayList<>();
    }

    public void initialiseLinkedListBased(){
        randomIntsLinkedList = new LinkedList<>();
        randomStringLinkedList = new LinkedList<>();
    }

    public int getIntAt(int location){
        return switch (mode) {
            case LISTBASED -> randomIntsList.get(location);
            case LINKEDLISTBASED -> randomIntsLinkedList.get(location);
        };
    }

    public void addIntTo(int element){
        switch (mode){
            case LISTBASED -> randomIntsList.add(element);
            case LINKEDLISTBASED -> randomIntsLinkedList.addLast(element);
        }
    }

    public void setIntTo(int location, int element){
        switch (mode){
            case LISTBASED -> randomIntsList.set(location, element);
            case LINKEDLISTBASED -> randomIntsLinkedList.set(location, element);
        }
    }

    public void addStringTo(String element){
        switch (mode){
            case LISTBASED -> randomStringList.add(element);
            case LINKEDLISTBASED -> randomStringLinkedList.addLast(element);
        }
    }

    public int getRandomIntSize(){
        return switch (mode) {
            case LISTBASED -> randomIntsList.size();
            case LINKEDLISTBASED -> randomIntsLinkedList.size();
        };
    }

}
