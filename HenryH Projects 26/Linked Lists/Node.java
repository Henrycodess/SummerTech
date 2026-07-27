public class Node {
    private Node nextNode;
    private int value;
    public Node(int value){
        this.value = value;
        this.nextNode = null;
    }
    public Node getNextNode(){
        return nextNode;
    }
    public int getValue(){
        return value;
    }
    public void setValue(int newValue){
        this.value = newValue;
    }
    public void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }
}
