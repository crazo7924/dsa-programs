import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Knapsack01 {

    int weight;

    public Knapsack01(int weight, Comparator<Item> comparator) {
        items = new PriorityQueue<>(comparator);
        this.weight = weight;
    }

    static Comparator<Item> byWeight = new Comparator<Item>() {

        @Override
        public int compare(Item first, Item second) {
            return first.weight - second.weight;
        }

    };

    static Comparator<Item> byProfit = new Comparator<Item>() {

        @Override
        public int compare(Item first, Item second) {
            return second.profit - first.profit;
        }

    };

    static Comparator<Item> byPWRatio = new Comparator<Item>() {

        @Override
        public int compare(Item first, Item second) {
            return first.profit / first.weight - second.profit / second.weight;
        }

    };

    PriorityQueue<Item> items;

    private int currentWeight = 0;

    public void fillKnapsack(List<Item> items) {
        this.items.addAll(items);
    }

    public List<Item> getSack() {
        List<Item> sack = new ArrayList<>();

        while (currentWeight + items.peek().weight <= weight) {
            currentWeight += items.peek().weight;
            sack.add(items.poll());
        }
        return sack;
    }

    public void addItem(int weight, int price, int position) {
        items.add(new Item(weight, price, position));
    }

    public static class Item {
        public Item(int weight, int price, int position) {
            this.position = position;
            this.weight = weight;
            this.profit = price;
        }

        int weight;
        int profit;
        int position;

        @Override
        public String toString() {
            return (position) + " [ profit = " + profit + ", weight = " + weight + " ]";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter weight of knapsack: ");
        int weight = scanner.nextInt();
        Knapsack01 knapsackByProfit = new Knapsack01(weight, byProfit);
        Knapsack01 knapsackByWeight = new Knapsack01(weight, byWeight);
        Knapsack01 knapsackbyRatio = new Knapsack01(weight, byPWRatio);
        System.out.print("\nEnter number of items: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("Item " + (i + 1));
            System.out.print("Price: ");
            int p = scanner.nextInt();
            System.out.print("Weight: ");
            int w = scanner.nextInt();
            System.out.println();
            knapsackByProfit.items.add(new Item(weight, p, i + 1));
            knapsackByWeight.items.add(new Item(weight, p, i + 1));
            knapsackbyRatio.items.add(new Item(weight, p, i + 1));
        }

        scanner.close();

        System.out.println("\nKnapsack contents are: ");

        int totalProfitByWeight = 0, totalProfitByProfit = 0, totalProfitByRatio = 0;
        for (Item item : knapsackByWeight.getSack()) {
            System.out.println(item);
            totalProfitByWeight += item.profit;
        }

        System.out.println();

        for (Item item : knapsackByProfit.getSack()) {
            System.out.println(item);
            totalProfitByProfit += item.profit;
        }
        System.out.println();

        for (Item item : knapsackbyRatio.getSack()) {
            System.out.println(item);
            totalProfitByRatio += item.profit;
        }

        System.out.println("\n\nDescending Order of profit.\nTotal profit = " + totalProfitByWeight);
        System.out.println("\nAscending Order of weight.\nTotal profit = " + totalProfitByProfit);
        System.out.println(
                "\nDescending Order of profit/weight ratio.\nTotal profit = " + totalProfitByRatio);
    }
}
