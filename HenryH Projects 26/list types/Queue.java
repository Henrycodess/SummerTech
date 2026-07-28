import java.util.ArrayList;
public class Queue {
    private ArrayList<Integer> queueList;
    public Queue(){
        this.queueList = new ArrayList<Integer>();
    }
    public void push(int value){
        queueList.add(value);
    }
    public int pop(){
        try {
            return queueList.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }
    public boolean isEmpty(){
        return queueList.isEmpty();
    }
    public int getNext(){
        return queueList.get(0);
    }
    public int getSize(){
        return queueList.size();
    }
}