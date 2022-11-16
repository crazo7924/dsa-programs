public class Queue {
    private Integer queue[];
    private int front;

    public Queue(int size) {
        front = -1;
        queue = new Integer[size];
    }

    public void enqueue(int input) {
        if (front == queue.length - 1) {
            System.out.println("Queue is full");
            return;
        }
        front++;
        for (int i = front; i > 0; i--)
            queue[i] = queue[i - 1]; // shifts all one place forward.
        queue[0] = input;
        System.out.println("Enqueued " + input);

    }

    public Integer dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return null;
        }
        int output = queue[front];
        queue[front--] = null;
        System.out.println("Dequeued " + output);
        return output;
    }

    public static void main(String args[]) {
        Queue q = new Queue(3);
        q.enqueue(5);
        q.enqueue(7);
        q.enqueue(9);
        q.enqueue(13); // Queue is full
        q.dequeue(); // 5
        q.dequeue(); // 7
        q.dequeue(); // 9
        q.dequeue(); // Queue was already empty
    }
}
