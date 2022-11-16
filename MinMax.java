import java.util.Scanner;

public final class MinMax {
    public int[] find(int[] list, int start, int end) {
        int min, max;
        if (start == end) {
            // small problem with 1 element
            max = min = list[start];
        } else if (start == end - 1) {
            // small problems with 2 elements
            if (list[start] > list[end]) {
                max = list[start];
                min = list[end];
            } else {
                min = list[start];
                max = list[end];
            }
        } else {

            // not a small problem.
            // perform divide and conquer recursively.
            int mid = (start + end) / 2;
            int[] minmax1 = find(list, start, mid);
            int[] minmax2 = find(list, mid + 1, end);
            if (minmax1[0] < minmax2[0])
                min = minmax1[0];
            else
                min = minmax2[0];
            if (minmax1[1] > minmax2[1])
                max = minmax1[1];
            else
                max = minmax2[1];
        }
        return new int[] {min, max};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int size = sc.nextInt();
        sc.nextLine();

        int[] a = new int[size];



        System.out.println("Enter elements of array:");
        for (int i = 0; i < size; i++) {
            System.out.print("\nElement " + (i + 1) + ": ");
            a[i] = sc.nextInt();
            sc.nextLine();
        }


        sc.close();

        MinMax minMax = new MinMax();
        int[] result = minMax.find(a, 0, a.length - 1);
        System.out.println("Maximum is " + result[1] + " and Minimum is " + result[0]);
    }
}
