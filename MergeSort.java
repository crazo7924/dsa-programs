import java.util.Scanner;

public final class MergeSort {

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

    private void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);

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
        sc.close();

        MergeSort merge = new MergeSort();
        merge.sort(a, 0, a.length - 1);
        for (int i : a)
            System.out.print("" + i);
        System.out.println();
    }
}
