import java.util.Scanner;

public final class QuickSort {

    private int[] a;

    public void sort() {
        sort(a, 0, a.length - 1);
    }

    public QuickSort(int[] a) {
        this.a = a;
    }

    private void sort(int[] list, int low, int high) {
        if (high - low <= 0)
            return;
        int key = list[low];
        int j = partition(list, low, high, key);
        sort(list, low, j - 1);
        sort(list, j + 1, high);
    }

    private int partition(int[] list, int low, int high, int pivot) {

        // pointer for greater element
        int key = list[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (list[i++] > key);
            while (list[j--] < key);

            if (i < j)
                swap(i, j);
        }

        if (i > j) {
            int temp = a[j];
            a[j] = key;
            key = temp;
        }

        return j;
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

        QuickSort qSort = new QuickSort(a);
        qSort.sort();
        System.out.println("After sorting: ");
        qSort.print();

        sc.close();
    }

    private void print() {
        for (int i : a) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}
