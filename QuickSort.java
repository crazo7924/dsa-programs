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
        int pivot = list[high];
        int partition = partition(list, low, high, pivot);
        sort(list, low, partition - 1);
        sort(list, partition + 1, high);
    }

    private int partition(int[] list, int low, int high, int pivot) {

        // pointer for greater element
        int i = low - 1;

        // traverse through all the elements
        // compare each element with the pivot
        for (int j = low; j < high; j++) {
            if (list[j] < pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                swap(i, j);
                i++;
            }

        }

        // swap the pivot element with the greater element specified by i
        swap(i + 1, high);

        // return the position from where partition is done
        return (i + 1);
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
