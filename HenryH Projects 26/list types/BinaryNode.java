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
    public void setLeftNode(BinaryNode newNode){
        leftNode = newNode;
    }
    public void setRightNode(BinaryNode newNode){
        rightNode = newNode;
    }
    public void setValue(int value){
        this.value = value;
    }
}