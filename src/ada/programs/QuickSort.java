package ada.programs;

import ada.utils.Sortable;
import ada.utils.Utils;

public final class QuickSort implements Sortable {
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
            if (list[j] < pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                Utils.swap(list, i, j);
                i++;
            }

        }

        // swap the pivot element with the greater element specified by i
        Utils.swap(list, i + 1, high);

        // return the position from where partition is done
        return (i + 1);
    }
}
