import java.util.Scanner;

public class MergeSort {

    /**
     * Merges two subarrays of numbers[].
     * First subarray is numbers[l..m]
     * Second subarray is numbers[m+1..r]
     */
    void merge(int numbers[], int left, int mid, int right) {
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // Instantiate two temporary arrays for the halves
        int L[] = new int[sizeLeft];
        int R[] = new int[sizeRight];

        // Copy over the two halves in those temporary arrays
        System.arraycopy(numbers, left, L, 0, sizeLeft);
        System.arraycopy(numbers, mid + 1, R, 0, sizeRight);

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (L[i] <= R[j]) {
                numbers[k] = L[i];
                i++;
            } else {
                numbers[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < sizeLeft) {
            numbers[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < sizeRight) {
            numbers[k] = R[j];
            j++;
            k++;
        }
    }

    // sort function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter size of the array: ");

        int size = scanner.nextInt();
        int list[] = new int[size];

        System.out.println("\nEnter the numbers:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            list[i] = scanner.nextInt();
        }

        scanner.close();

        MergeSort m = new MergeSort();

        m.sort(list, 0, size - 1);

        System.out.println("\nSorted list is:");
        for (int i : list) {
            if (i != list[list.length - 1])
                System.out.print(i + ", ");
            else
                System.out.print(i + "\n");
        }
    }
}
