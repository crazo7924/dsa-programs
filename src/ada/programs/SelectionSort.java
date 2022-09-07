package ada.programs;

import ada.utils.Algorithm;

public final class SelectionSort extends Algorithm {

    public void sort(int list[]) {
        int length = list.length;

        // One by one move limit of unsorted subarray
        for (int i = 0; i < length - 1; i++) {
            // Find the minimum element in unsorted array
            int min = i;
            for (int j = i + 1; j < length; j++)
                if (list[j] < list[min])
                    min = j;

            swap(list, min, i);
        }
    }
}
