package ada.utils;

import java.util.Scanner;

public class Utils {

    public static void swap(int[] list, int a, int b) {
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    public static int[] readIntArray(Scanner scanner) {
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

    public static int readInt(Scanner scanner) {
        System.out.println("\nEnter an integer: ");
        int x = scanner.nextInt();
        return x;
    }

    public static void printIntArray(int list[]) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}