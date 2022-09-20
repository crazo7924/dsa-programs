import java.util.Scanner;

public class Stack {

    private int stack[], head;

    public Stack() {
        head = -1;
        stack = null;
    }

    public void push(int input) {
        if (head == -1) {
            stack = new int[1];
            stack[++head] = input;
            return;
        }

        head++;

        int temp[] = new int[head];
        temp[head] = input;
        System.arraycopy(stack, 0, temp, 0, head);
        stack = temp;
    }

    public Integer pop() {
        if (head == -1)
            return null;

        head--;
        int temp[] = new int[head];
        System.arraycopy(stack, 0, temp, 0, head);
        stack = temp;

        return stack[head];
    }

    public void print() {
        if (head == -1)
            System.out.println("Queue is empty.");
        else {

        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            stack.print();
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("0. Exit");

            System.out.print("\nEnter choice of operation: ");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter a number to enqueue: ");
                int input = sc.nextInt();
                stack.push(input);
                stack.print();
            } else if (choice == 2) {
                Integer output = stack.pop();
                if (output != null)
                    System.out.println("de-queued values is " + output);
                stack.print();
            }
        } while (choice != 0);
        sc.close();
    }
}
