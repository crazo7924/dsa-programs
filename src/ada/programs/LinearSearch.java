package ada.programs;

import ada.utils.Searchable;

public final class LinearSearch implements Searchable {
    public int search(int[] list, int x) {
        for (int i = 0; i < list.length; i++)
            if (list[i] == x)
                return i;
        return -1;
    }
}