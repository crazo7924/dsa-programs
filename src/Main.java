import java.util.Scanner;

import ada.programs.BinarySearch;
import ada.programs.BubbleSort;
import ada.programs.InsertionSort;
import ada.programs.LinearSearch;
import ada.programs.MergeSort;
import ada.programs.MinMax;
import ada.programs.QuickSort;
import ada.programs.SelectionSort;
import ada.utils.Utils;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int list[], x, result, choice = 9;

        while (choice != 0) {

            System.out.println("\n1. BinarySearch");
            System.out.println("2. LinearSearch");
            System.out.println("3. BubbleSort");
            System.out.println("4. InsertionSort");
            System.out.println("5. MergeSort");
            System.out.println("6. QuickSort");
            System.out.println("7. SelectionSort");
            System.out.println("8. MinMax");
            System.out.println("0. Exit");

            System.out.print("\nEnter choice: ");
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                continue;
            }

            switch (choice) {
                case 1:
                    list = Utils.readIntArray(scanner);
                    x = Utils.readInt(scanner);

                    BinarySearch binary = new BinarySearch();

                    result = binary.search(list, x);
                    if (result == -1)
                        System.out.println("\nNot Found");
                    else
                        System.out.println("\nFound at position" + (result + 1));
                    break;
                case 2:
                    list = Utils.readIntArray(scanner);
                    x = Utils.readInt(scanner);
                    LinearSearch linear = new LinearSearch();
                    result = linear.search(list, x);
                    if (result == -1)
                        System.out.println("\nNot Found");
                    else
                        System.out.println("\nFound at position " + (result + 1));
                    break;
                case 3:
                    list = Utils.readIntArray(scanner);
                    BubbleSort bubble = new BubbleSort();
                    bubble.sort(list);
                    Utils.printIntArray(list);
                    break;
                case 4:
                    list = new int[1];
                    InsertionSort insertionSort = new InsertionSort();
                    for (int i = 0; i < list.length; i++) {
                        int element = Utils.readInt(scanner);
                        list = insertionSort.insert(list, element);
                        insertionSort.sort(list);
                        System.out.println("\nAfter inserting " + element);
                        Utils.printIntArray(list);
                    }
                    break;
                case 5:
                    list = Utils.readIntArray(scanner);
                    MergeSort merge = new MergeSort();
                    merge.sort(list);
                    Utils.printIntArray(list);
                    break;
                case 6:
                    list = Utils.readIntArray(scanner);
                    QuickSort quick = new QuickSort();
                    quick.sort(list);
                    Utils.printIntArray(list);
                    break;
                case 7:
                    list = Utils.readIntArray(scanner);
                    SelectionSort selection = new SelectionSort();
                    selection.sort(list);
                    Utils.printIntArray(list);
                    break;
                case 8:
                    list = Utils.readIntArray(scanner);
                    MinMax minMax = new MinMax();
                    int[] output = minMax.find(list, 0, list.length - 1);
                    System.out.println("\nMin is " + output[0]);
                    System.out.println("Max is " + output[1]);
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Try again.");
            }

        }
    }

}
