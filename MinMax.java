import java.util.Scanner;

public class MinMax {
    int[] find(int[] list, int i, int j) {
        int min, max;
        if (i == j) {
            max = min = list[i];
        } else if (i == j - 1) {
            if (list[i] > list[j]) {
                max = list[i];
                min = list[j];
            } else {
                min = list[i];
                max = list[j];
            }
        } else {
            int mid = (i + j) / 2;
            int[] minmax1 = find(list, i, mid);
            int[] minmax2 = find(list, mid + 1, j);

            if (minmax1[0] < minmax2[0])
                min = minmax1[0];
            else
                min = minmax2[0];

            if (minmax1[1] >minmax2[1])
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
    }
}
