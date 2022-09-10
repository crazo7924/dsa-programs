package ada.programs;

import ada.utils.Searchable;

public final class BinarySearch implements Searchable {

    @Override
    public int search(int sortedNumbers[], int number) {
        int low = 0;
        int high = sortedNumbers.length - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            if (number == sortedNumbers[mid])
                return mid;
            else if (number > sortedNumbers[mid])
                low = mid + 1;
            else if (number < sortedNumbers[mid])
                high = mid - 1;
        }
        return -1;
    }
}
