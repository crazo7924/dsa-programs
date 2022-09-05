import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TakeInput input = new TakeInput();
        int[] list = input.getArray(scanner);
        scanner.close();

        BubbleSort b = new BubbleSort();
        b.sort(list);
        System.out.println("\nBubble sorted: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
        }
        System.out.println();
    }

    private void sort(int[] list) {
        for (int i = list.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}
