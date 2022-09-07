import java.util.Scanner;

import ada.programs.BinarySearch;
import ada.programs.BubbleSort;
import ada.programs.InsertionSort;
import ada.programs.LinearSearch;
import ada.programs.MergeSort;
import ada.programs.MinMax;
import ada.programs.QuickSort;
import ada.programs.SelectionSort;
import ada.utils.Algorithm;
import ada.utils.TakeInput;

public class Main {
    static void printIntArray(int list[]) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TakeInput input = new TakeInput();
        int list[], x, result, choice = 9;
        Algorithm algorithm;

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
                    list = input.getIntArray(scanner);
                    x = input.getInt(scanner);
                    algorithm = new BinarySearch();
                    result = algorithm.search(list, x);
                    if (result == -1)
                        System.out.println("\nNot Found");
                    else
                        System.out.println("\nFound at position" + (result + 1));
                    break;
                case 2:
                    list = input.getIntArray(scanner);
                    x = input.getInt(scanner);
                    algorithm = new LinearSearch();
                    result = algorithm.search(list, x);
                    if (result == -1)
                        System.out.println("\nNot Found");
                    else
                        System.out.println("\nFound at position " + (result + 1));
                    break;
                case 3:
                    list = input.getIntArray(scanner);
                    algorithm = new BubbleSort();
                    algorithm.sort(list);
                    printIntArray(list);
                    break;
                case 4:
                    list = new int[1];
                    InsertionSort insertionSort = new InsertionSort();
                    for (int i = 0; i < list.length; i++) {
                        int element = input.getInt(scanner);
                        list = insertionSort.insert(list, element);
                        insertionSort.sort(list);
                        System.out.println("\nAfter inserting " + element);
                        printIntArray(list);
                    }
                    break;
                case 5:
                    list = input.getIntArray(scanner);
                    algorithm = new MergeSort();
                    algorithm.sort(list);
                    printIntArray(list);
                    break;
                case 6:
                    list = input.getIntArray(scanner);
                    algorithm = new QuickSort();
                    algorithm.sort(list);
                    printIntArray(list);
                    break;
                case 7:
                    list = input.getIntArray(scanner);
                    algorithm = new SelectionSort();
                    algorithm.sort(list);
                    printIntArray(list);
                    break;
                case 8:
                    list = input.getIntArray(scanner);
                    MinMax minMax = new MinMax();
                    int[] output = minMax.find(list, 0, list.length - 1);
                    System.out.println("\nMin is " + output[0]);
                    System.out.println("Max is " + output[1]);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice");
            }

        }
        scanner.close();
    }

}
