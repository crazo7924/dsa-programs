import java.util.Scanner;

/**
 * BinarySearch
 */
public class BinarySearch {
    int search(int sortedNumbers[], int number, int low, int high) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TakeInput tInput = new TakeInput();
        int[] list = tInput.getArray(scanner);
        int x = tInput.getInt(scanner);
        scanner.close();

        BinarySearch b = new BinarySearch();
        int position = b.search(list, x, 0, list.length - 1);

        if (position == -1)
            System.out.println("\nNot Found\n");
        else
            System.out.println("\nFound at position " + (position + 1) + '\n');
    }
}
