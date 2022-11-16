import java.util.Scanner;

public final class InsertionSort {

    private int[] list;
    private int size;

    public boolean insert(int x) {
        if (list.length == size)
            return false;
        sort();
        System.out.println("After sorting: ");
        print();
        return true;
    }

    InsertionSort(int size) {
        list = new int[size];
    }

    public void sort() {
        int length = list.length;

        for (int i = 0; i < length - 1; i++) {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i + 1; j < length; j++)
                if (list[j] < list[min])
                    min = j;
            swap(min, i);
        }
    }

    public void print() {
        for (int i : list)
            System.out.print(" " + i);
        System.out.println();
    }

    private void swap(int i, int j) {
        int temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        InsertionSort insertionSort = new InsertionSort(size);
        boolean canInsert = true;
        do {
            System.out.print("Enter element to insert: ");
            canInsert = insertionSort.insert(sc.nextInt());
            sc.nextLine();
        } while (canInsert);
        System.out.println("The array is filled.");
        insertionSort.print();
        sc.close();
    }
}
