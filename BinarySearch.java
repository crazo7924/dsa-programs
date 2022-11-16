import java.util.Scanner;

public final class BinarySearch {

    public int search(int[] a, int number) {
        int low = 0;
        int high = a.length - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            if (number == a[mid])
                return mid;
            else if (number > a[mid])
                low = mid + 1;
            else if (number < a[mid])
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter elements of SORTED array:");
        int numbers[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("\nElement " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
            sc.nextLine();
        }

        BinarySearch binary = new BinarySearch();

        System.out.print("\nEnter number to search: ");
        int x = sc.nextInt();
        sc.nextLine();

        int output = binary.search(numbers, x);

        if (output == -1)
            System.out.println("Not found.");
        else
            System.out.println("Found " + x + " at position " + (output + 1));
        sc.close();
    }
}
