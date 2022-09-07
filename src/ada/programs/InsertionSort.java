package ada.programs;

import ada.utils.Algorithm;

public final class InsertionSort extends Algorithm {

    public int[] insert(int[] list, int x) {
        int[] list2 = new int[list.length + 1];
        System.arraycopy(list, 0, list2, 0, list.length);
        return list2;
    }

    @Override
    public void sort(int[] list) {
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
