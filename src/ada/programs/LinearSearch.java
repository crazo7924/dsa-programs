package ada.programs;

import ada.utils.Algorithm;

public final class LinearSearch extends Algorithm {
    public int search(int[] list, int x) {
        for (int i = 0; i < list.length; i++)
            if (list[i] == x)
                return i;
        return super.search(list, x);
    }
}