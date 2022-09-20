import java.util.Scanner;

public final class BinarySearch {

    private int[] a;

    public int search(int number) {
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

    public void init(int[] a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        BinarySearch b = new BinarySearch();
        System.out.println("Enter elements of SORTED array:");
        int a[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("\nElement " + (i + 1) + ": ");
            a[i] = sc.nextInt();
            System.out.println();
        }
        b.init(a);

        System.out.print("\nEnter number to search: ");
        int n = sc.nextInt();

        int output = b.search(n);
        if (output == -1)
            System.out.println("Not found.");
        else
            System.out.println("Found " + n + " at index " + (output + 1));

        sc.close();
    }
}
