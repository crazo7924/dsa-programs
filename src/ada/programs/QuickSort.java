package ada.programs;

import ada.utils.Algorithm;

public final class QuickSort extends Algorithm {
    public void sort(int[] list) {
        sort(list, 0, list.length);
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
}
