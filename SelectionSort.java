import java.util.Scanner;

public final class SelectionSort {

    private int[] a;

    public SelectionSort(int[] a) {
        this.a = a;
    }

    public void sort(int list[]) {
        int length = list.length;

        // One by one move limit of unsorted subarray
        for (int i = 0; i < length - 1; i++) {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i + 1; j < length; j++)
                if (list[j] < list[min])
                    min = j;

            swap(min, i);
        }
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        int[] a = new int[size];

        System.out.println("Enter elements of array:");
        for (int i = 0; i < size; i++) {
            System.out.print("\nElement " + (i + 1) + ": ");
            a[i] = sc.nextInt();
            System.out.println();
        }

        SelectionSort s = new SelectionSort(a);
        s.sort();
        System.out.println("After sorting: ");
        s.print();

        sc.close();
    }

    private void print() {
        for (int i : a) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    private void sort() {
        sort(a);
    }
}
