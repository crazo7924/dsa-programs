import java.util.Scanner;

public final class SelectionSort {

    public void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (a[j] > a[i]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        int[] a = new int[size];

        System.out.println("Enter elements of array:");
        for (int i = 0; i < size; i++) {
            System.out.print("\nElement " + (i + 1) + ": ");
            a[i] = sc.nextInt();
            System.out.println();
        }
        SelectionSort selection = new SelectionSort();
        selection.sort(a);
        sc.close();
    }
}
