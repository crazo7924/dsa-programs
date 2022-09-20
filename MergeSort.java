import java.util.Scanner;

public final class MergeSort {

    private int comparisons;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    /**
     * Merges two subarrays of numbers[]. First subarray is numbers[l..m] Second subarray is
     * numbers[m+1..r]
     */
    private void merge(int numbers[], int left, int mid, int right) {
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // Instantiate two temporary arrays for the halves
        int output[] = new int[numbers.length];

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (numbers[i] < numbers[j])
                output[k++] = numbers[i++];
            else
                output[k++] = numbers[j++];
        }

        /* Copy remaining elements of L[] if any */
        while (i < sizeLeft) {
            output[k++] = numbers[i++];
        }

        /* Copy remaining elements of R[] if any */
        while (j < sizeRight) {
            output[k++] = numbers[j++];
        }

        numbers = output;
    }

    // sort function that sorts arr[l..r] using
    // merge()
    public void sort() {
        sort(arr, 0, arr.length - 1);
        System.out.println("\nComparisons performed: " + comparisons);
    }

    private int[] arr;

    private void sort(int arr[], int l, int r) {
        if (l < r) {
            comparisons++;
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
        MergeSort m = new MergeSort(a);
        m.sort();

        sc.close();
    }
}
