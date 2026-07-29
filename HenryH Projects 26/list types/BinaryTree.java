public class BinaryTree {
    private BinaryNode head;
    public BinaryTree(){
        this.head = null;
    }
    public BinaryTree(int value){
        this.head  = new BinaryNode(value);
    }
    public void addNode(int value, BinaryNode currentNode){
        if (value < currentNode.getValue()){
            currentNode = currentNode.getLeftNode();
            if (currentNode == null){
                currentNode = new BinaryNode(value);
            }
            else{
                addNode(value, currentNode);
            }
        }
        else{
            currentNode = currentNode.getRightNode();
            if (currentNode == null){
                currentNode = new BinaryNode(value);
            }
            else{
                addNode(value, currentNode);
            }
        }
    }
}
    