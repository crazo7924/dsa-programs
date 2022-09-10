package ada.programs;

public class Stack {

    private int head, list[];

    Stack(int size) {
        head = 0;
        list = new int[size];
    }

    public void push(int input) {
        int list2[] = new int[head + 1];
        System.arraycopy(list, 0, list2, 0, head);
        list2[head++] = input;
        list = list2;
    }

    public int pop() {
        int list2[] = new int[head - 1];
        System.arraycopy(list, 0, list2, 0, head - 1);
        list = list2;
        return list[head--];
    }
}
