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
        System.out.println("\nEnter size of the array: ");

        int size = scanner.nextInt();
        int list[] = new int[size];

        System.out.println("\nEnter the numbers in sorted order");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            list[i] = scanner.nextInt();
        }

        System.out.println("\nEnter the number to find: ");
        int x = scanner.nextInt();
        scanner.close();

        BinarySearch b = new BinarySearch();
        int position = b.search(list, x, 0, size - 1);

        if (position == -1)
            System.out.println("\nNot Found\n");
        else
            System.out.println("\nFound at position " + (position + 1) + '\n');
    }
}
