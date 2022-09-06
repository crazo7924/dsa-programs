import java.util.Scanner;

public class MinMax {
    int[] find(int[] list, int start, int end) {
        int min, max;
        if (start == end) { // small problem with 1 elements
            max = min = list[start];
        } else if (start == end - 1) { // small problems with 2 elements
            if (list[start] > list[end]) {
                max = list[start];
                min = list[end];
            } else {
                min = list[start];
                max = list[end];
            }
        } else { // not a small problem. perform divide and conquer recursively.
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
        return new int[] { min, max };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TakeInput input = new TakeInput();
        MinMax m = new MinMax();
        System.out.println("\nEnter elements of the list: ");
        int[] list = input.getArray(scanner);
        int[] minmax = m.find(list, 0, list.length - 1);
        System.out.println("Minimum is: " + minmax[0] + " and Maximum is " + minmax[1]);
        scanner.close();
    }
}
