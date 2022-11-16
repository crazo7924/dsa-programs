import java.util.Scanner;

public final class LinearSearch {
    public int search(int[] numbers, int x) {
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] == x)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the numbers:");
        int numbers[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("\nElement " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
            scanner.nextLine();
        }

        LinearSearch linear = new LinearSearch();

        System.out.print("\nEnter number to search: ");
        int x = scanner.nextInt();
        scanner.nextLine();

        int output = linear.search(numbers, x);
        if (output == -1)
            System.out.println("Not found.");
        else
            System.out.println("Found " + x + " at index " + (output + 1));
        scanner.close();
    }
}
