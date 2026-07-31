public class BinaryTree {
    private BinaryNode head;
    public BinaryTree(){
        this.head = null;
    }
    public BinaryTree(int value){
        this.head  = new BinaryNode(value);
    }
    public void printTree(){
        printTree(head);
    }
    public void printTree(BinaryNode currentNode){
        if (currentNode.getLeftNode() != null){
            printTree(currentNode.getLeftNode());
        }
        System.out.println(currentNode.getValue());
        if (currentNode.getRightNode() != null){
            printTree(currentNode.getRightNode());
        }
    }
    public void addNode(int value){
        addNode(value, this.head);
    }
    public void addNode(int value, BinaryNode currentNode){
        if (value < currentNode.getValue()){
            if (currentNode.getLeftNode() == null){
                currentNode.setLeftNode(new BinaryNode(value));
            }
            else{
                addNode(value, currentNode.getLeftNode());
            }
        }
        else{
            if (currentNode.getRightNode() == null){
                currentNode.setRightNode(new BinaryNode(value));
            }
            else{
                addNode(value, currentNode.getRightNode());
            }
        }
    }
    public BinaryNode searchNode(int value){
        return searchNode(value, head);
    }
    public BinaryNode searchNode(int value, BinaryNode currentNode){
        System.out.println(currentNode.getValue());
        if (value < currentNode.getValue()){
            return searchNode(value, currentNode.getLeftNode());
        }
        if (value > currentNode.getValue()){
            return searchNode(value, currentNode.getRightNode());
        }
        else{
            return currentNode;
        }

    }
    public void searchDelete(int value){
        searchDelete(value, head);
    }
    public void searchDelete(int value, BinaryNode currentNode){
        if (value < currentNode.getValue()){
            if (currentNode.getLeftNode() == null){
                return;
            }
            else{
                searchDelete(value, currentNode.getLeftNode());
                if (currentNode.getLeftNode().getValue() == value){
                    currentNode.setLeftNode(null);
                }
            }
        }
        else{
            if (currentNode.getRightNode() == null){
                return;
            }
            else{
                searchDelete(value, currentNode.getRightNode());
                if (currentNode.getRightNode().getValue() == value){
                    currentNode.setRightNode(null);
                }
            }
        }
    }
    public void deleteMiddle(int value){
        deleteMiddle(value, head);
    }
    public BinaryNode deleteMiddle(int value, BinaryNode prevNode){
        if (value < prevNode.getValue()){
            if (prevNode.getLeftNode() == null){
                return null;
            }
            else{
                deleteMiddle(value, prevNode.getLeftNode());
                if (prevNode.getLeftNode().getValue() == value){
                    deleteMiddle(value, prevNode.getLeftNode());
                    prevNode.setRightNode(prevNode.getLeftNode().getLeftNode());
                }
            }
        }
        else{
            if (prevNode.getRightNode() == null){
                return null;
            }
            else{
                deleteMiddle(value, prevNode.getRightNode());
                if (prevNode.getRightNode().getValue() == value){
                    prevNode.setRightNode(deleteMiddle(value, prevNode.getLeftNode()));
                    return null;
                }
            }
        }
    }
}   
//noodle prevNoodle = new Noodle(1);