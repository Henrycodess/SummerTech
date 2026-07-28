public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}