package ada.programs;

import ada.utils.Sortable;
import ada.utils.Utils;

public final class SelectionSort implements Sortable {

    public void sort(int list[]) {
        int length = list.length;

        // One by one move limit of unsorted subarray
        for (int i = 0; i < length - 1; i++) {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i + 1; j < length; j++)
                if (list[j] < list[min])
                    min = j;

            Utils.swap(list, min, i);
        }
    }
}
