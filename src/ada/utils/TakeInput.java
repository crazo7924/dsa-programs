package ada.utils;

import java.util.Scanner;

public class TakeInput {

    public int[] getIntArray(Scanner scanner) {
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

    public int getInt(Scanner scanner) {
        System.out.println("\nEnter an integer: ");
        int x = scanner.nextInt();
        return x;
    }
}
