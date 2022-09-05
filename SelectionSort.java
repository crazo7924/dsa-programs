import java.util.Scanner;

public class SelectionSort {

    void sort(int arr[]) {
        int n = arr.length;

        // One by one move limit of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min])
                    min = j;

            // Swap the found minimum element
            // with the first element
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TakeInput input = new TakeInput();
        int[] list = input.getArray(scanner);

        scanner.close();

        SelectionSort selection = new SelectionSort();
        selection.sort(list);

        System.out.println("\nSorted list:");
        for (int i = 0; i < list.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
