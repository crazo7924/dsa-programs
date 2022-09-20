import java.util.Scanner;

public final class LinearSearch {
    public int search(int x) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == x)
                return i;
        return -1;
    }

    private int[] a;

    public LinearSearch(int size) {
        a = new int[size];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        LinearSearch l = new LinearSearch(size);
        System.out.print("\nEnter number to search: ");
        int n = sc.nextInt();
        int output = l.search(n);
        if (output == -1)
            System.out.println("Not found.");
        else
            System.out.println("Found " + n + " at index " + (output + 1));
        sc.close();
    }
}
