import java.util.Scanner;

public final class Queue {

    private Integer queue[];
    private int head;

    public Queue(int size) {
        head = -1;
        queue = new Integer[size];
    }

    public void enqueue(int input) {
        if (head == -1) {
            System.out.println("Queue is full");
            return;
        }

        head++;
    }

    public Integer dequeue() {
        if (head == -1) {
            System.out.println("Queue is empty");
            return null;
        }

        queue[head] = null;
        return queue[head--];
    }

    public void print() {
        System.out.println("[ ");
        for (int i = 0; i <= head; i++) {
            System.out.print(" " + queue[i]);
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of queue: ");
        Queue q = new Queue(sc.nextInt());
        int choice;
        do {
            q.print();
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("0. Exit");

            System.out.print("\nEnter choice of operation: ");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("Enter a number to enqueue: ");
                int input = sc.nextInt();
                q.enqueue(input);
                q.print();
            } else if (choice == 2) {
                Integer output = q.dequeue();
                if (output == null)
                    continue;
                System.out.println("De-queued element is " + output);
                q.print();
            }
        } while (choice != 0);
        sc.close();
    }
}
