import java.util.Scanner;

/**
 * LinearSearch
 */
public class LinearSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TakeInput tInput = new TakeInput();
        int[] list = tInput.getArray(scanner);
        int x = tInput.getInt(scanner);
        scanner.close();

        LinearSearch l = new LinearSearch();
        int position = l.search(list, x);

        if (position == -1)
            System.out.println("\nNot Found\n");
        else
            System.out.println("\nFound at position " + (position + 1) + '\n');
    }

    private int search(int[] list, int x) {
        for (int i = 0; i < list.length; i++)
            if (list[i] == x)
                return i;
        return -1;
    }
}