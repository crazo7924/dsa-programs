import java.util.Scanner;

public final class Queue {

    int queue[], head;

    public Queue() {
        head = -1;
        queue = null;
    }

    public void enqueue(int input) {
        if (head == -1) {
            head++;
            queue = new int[1];
            queue[head] = input;
            return;
        }

        head++;

        int temp[] = new int[head];
        temp[0] = input;
        System.arraycopy(queue, 0, temp, 1, head);

        queue = temp;
    }

    public Integer dequeue() {
        if (head == -1)
            return null;

        head--;

        int temp[] = new int[head];
        System.arraycopy(queue, 0, temp, 0, head);
        queue = temp;

        return queue[head];
    }

    public void print() {
        if (head == -1)
            System.out.println("Queue is empty.");
        else {
            for (int i : queue) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        Scanner sc = new Scanner(System.in);
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
                if (output != null)
                    System.out.println("de-queued values is " + output);
                q.print();
            }
        } while (choice != 0);
        sc.close();
    }
}
