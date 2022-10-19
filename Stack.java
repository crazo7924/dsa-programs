import java.util.Scanner;

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
        stack[++head] = input;
    }

    public Integer pop() {
        if (head == -1) {
            System.out.println("Stack is empty");
            return null;
        }

        stack[head] = null;
        return stack[head--];
    }

    public void print() {
        System.out.print("[ ");
        for (int i = 0; i <= head; i++) {
            System.out.print(" " + stack[i]);
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of stack: ");
        Stack stack = new Stack(sc.nextInt());
        int choice;
        do {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("0. Exit");

            System.out.print("\nEnter choice of operation: ");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter a number to push: ");
                int input = sc.nextInt();
                stack.push(input);
                stack.print();
            } else if (choice == 2) {
                Integer output = stack.pop();
                if (output == null)
                    continue;

                System.out.println("popped element is " + output);
                stack.print();
            } else {
                System.out.println("Invalid choice");
            }
        } while (choice != 0);
        sc.close();
    }
}
