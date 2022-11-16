public class Stack {
    private Integer stack[];
    private int head;

    public Stack(int size) {
        head = -1;
        stack = new Integer[size];
    }

    public void push(int input) {
        if (head == stack.length - 1) {
            System.out.println("Stack is full");
            return;
        }
        System.out.println("Pushed " + input);
        stack[++head] = input;
    }

    public Integer pop() {
        if (head == -1) {
            System.out.println("Stack is empty");
            return null;
        }
        int output = stack[head];
        stack[head--] = null;
        System.out.println("Popped " + output);
        return output;
    }

    public static void main(String args[]) {
        Stack stack = new Stack(3);
        stack.push(2);
        stack.push(9);
        stack.push(76);
        stack.push(42); // Stack is full.
        stack.pop(); // 76
        stack.pop(); // 9
        stack.pop(); // 2
        stack.pop(); // Stack was already empty.
    }
}
