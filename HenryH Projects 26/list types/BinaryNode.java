public class BinaryNode {
    private int value;
    private BinaryNode leftNode;
    private BinaryNode rightNode;
    public BinaryNode(int value){
        this.value = value;
        this.leftNode = null;
        this.rightNode = null;
    }
    public BinaryNode getLeftNode(){
        return leftNode;
    }
    public BinaryNode getRightNode(){
        return rightNode;
    }
    public int getValue(){
        return value;
    }
}