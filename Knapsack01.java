import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Knapsack01 {

    int maxWeight;
    int totalProfit = 0;
    List<Item> items;
    int currentWeight = 0;

    public Knapsack01(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    static Comparator<Item> byWeight = new Comparator<Item>() {

        @Override
        public int compare(Item a, Item b) {
            return a.weight - b.weight;
        }
    };

    static Comparator<Item> byProfit = new Comparator<Item>() {

        @Override
        public int compare(Item a, Item b) {
            return b.profit - a.profit;
        }
    };

    static Comparator<Item> byPWRatio = new Comparator<Item>() {

        @Override
        public int compare(Item a, Item b) {
            return (b.profit / b.weight) - (a.profit / a.weight);
        }
    };

    public class Item {

        public Item(int weight, int profit, int position) {
            this.position = position;
            this.weight = weight;
            this.profit = profit;
        }

        int weight;
        int profit;
        int position;

        @Override
        public String toString() {
            return (position) + " [ profit = " + profit + ", weight = " + weight + " ]";
        }
    }

    public void fill(List<Item> input, Comparator<Item> comparator) {
        items.clear();
        for (Item item : input) {
            if (item.weight + currentWeight > maxWeight)
                continue;
            items.add(item);
            items.sort(comparator);
            currentWeight += item.weight;
            totalProfit += item.profit;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter max weight of knapsack: ");
        int maxWeight = scanner.nextInt();
        scanner.nextLine();

        Knapsack01 knapsack = new Knapsack01(maxWeight);

        System.out.print("\nEnter number of items: ");

        int count = scanner.nextInt();
        scanner.nextLine();

        List<Knapsack01.Item> inputItems = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.println("Item " + (i + 1));

            System.out.print("Price: ");
            int p = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Weight: ");
            int w = scanner.nextInt();
            scanner.nextLine();

            inputItems.add(knapsack.new Item(w, p, i + 1));
        }

        scanner.close();

        knapsack.fill(inputItems, byProfit);
        System.out.println("With descending order of profits, items are:");
        for (Item item : knapsack.items) {
            System.out.println(item);
        }
        System.out.println("and total profit is " + knapsack.totalProfit);

        knapsack.fill(inputItems, byWeight);
        System.out.println("With ascending order of weights, items are:");
        for (Item item : knapsack.items) {
            System.out.println(item);
        }
        System.out.println("and total profit is " + knapsack.totalProfit);

        knapsack.fill(inputItems, byProfit);

        System.out.println("With descending order of profit/weight ratio, items are:");
        for (Item item : knapsack.items) {
            System.out.println(item);
        }
        System.out.println("and total profit is " + knapsack.totalProfit);
    }
}
