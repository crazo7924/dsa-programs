import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter size of the list: ");

        int size = scanner.nextInt();
        List<Integer> list = new ArrayList<>(size);

        System.out.println("\nEnter the numbers:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            list.add(scanner.nextInt());
            list.sort(Comparator.naturalOrder());
            System.out.println("\nThe sorted list after insertion: ");
            for (int j : list)
                System.out.print(j + " ");
        }
        scanner.close();
    }
}
