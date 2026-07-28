public class LinkedList {
    private Node head;
    private int length;
    public LinkedList(){
        this.length = 0;
        this.head = null;
    }
    public Node getHead(){
        return head;
    }
    public int getLength(){
        return length;
    }
    public void addNode(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
            length++;
            return;            
        }
        Node tempNext = head;
        for (int i = 0; i < length - 1; i++){
            tempNext = tempNext.getNextNode();
        }
        tempNext.setNextNode(newNode);
        length++;
    }
    public void removeNode(int value){
        Node tempNext = head;
        if (head.getValue() == value){
            head = tempNext.getNextNode();
            length--;
            return;
        }
        for (int i = 0; i < length - 1; i++){
            if (tempNext.getNextNode().getNextNode() == null){
                if (tempNext.getNextNode().getValue() == value){
                    tempNext.setNextNode(null);
                    length--;
                    return;
                }
            }
            if (tempNext.getNextNode().getValue() == value){
                tempNext.setNextNode(tempNext.getNextNode().getNextNode());
                length--;
                return;
            }
            tempNext = tempNext.getNextNode();
        }
    }
    public void printList(){
        Node tempNext = head;
        for (int i = 0; i < length; i++){
            System.out.println(tempNext.getValue());
            tempNext = tempNext.getNextNode();
        }
    }
}
