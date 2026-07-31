public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(4);
        tree.addNode(5);
        tree.addNode(9);
        tree.addNode(6);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(1);
        tree.printTree();
        tree.deleteMiddle(4);
        System.out.println("new tree");
        tree.printTree();
    }
}