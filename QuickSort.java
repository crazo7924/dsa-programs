import java.util.Scanner;

public class QuickSort {
    public void sort(int[] list, int low, int high) {
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
            if (list[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                swap(list, i, j);
            }

        }

        // swap the pivot element with the greater element specified by i
        swap(list, i + 1, high);

        // return the position from where partition is done
        return (i + 1);
    }

    private void swap(int[] list, int first, int second) {
        int temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }

    public static void main(String[] args) {
        TakeInput input = new TakeInput();
        Scanner scanner = new Scanner(System.in);
        QuickSort quick = new QuickSort();
        int[] list = input.getArray(scanner);

        quick.sort(list, 0, list.length - 1);

        System.out.println("\nSorted list:");
        for (int i : list)
            System.out.print(i + " ");
        System.out.println();
    }
}
