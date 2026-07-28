import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> stackList;
    public Stack(){
        this.stackList = new ArrayList<Integer>();
    }
    public void push(int value){
        stackList.add(value);
    }
    public int pop(){
        try {
            return stackList.remove(stackList.size() - 1);
        }
        catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }
    public boolean isEmpty(){
        return stackList.isEmpty();
    }
    public int getNext(){
        return stackList.get(stackList.size() - 1);
    }
    public int getSize(){
        return stackList.size();
    }
}
