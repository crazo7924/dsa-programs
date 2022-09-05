import java.util.Scanner;

public class TakeInput {

    int[] getArray(Scanner scanner) {
        System.out.println("\nEnter size of the array: ");

        int size = scanner.nextInt();
        int list[] = new int[size];

        System.out.println("\nEnter the numbers");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            list[i] = scanner.nextInt();
        }

        return list;
    }

    int getInt(Scanner scanner) {
        System.out.println("\nEnter the number to find: ");
        int x = scanner.nextInt();
        return x;
    }
}
