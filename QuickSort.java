import java.util.Scanner;

public final class QuickSort {

    public void sort(int[] list, int low, int high) {
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

            if (i < j) {
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        if (i > j) {
            int temp = list[j];
            list[j] = key;
            key = temp;
        }

        return j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        sc.nextLine();
        int[] a = new int[size];

        System.out.println("Enter elements of array:");
        for (int i = 0; i < size; i++) {
            System.out.print("\nElement " + (i + 1) + ": ");
            a[i] = sc.nextInt();
            sc.nextLine();
        }

        sc.close();

        QuickSort quick = new QuickSort();
        quick.sort(a, 0, a.length - 1);
        System.out.println("After sorting: ");
        for (int i : a)
            System.out.print(" " + i);
        System.out.println();
    }
}
