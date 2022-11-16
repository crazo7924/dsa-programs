import java.util.ArrayList;
import java.util.Scanner;

public class DFS {

    final int max = 99999;
    int n;
    boolean[] visitedArray;

    DFS(int n) {
        visitedArray = new boolean[n];
    }

    ArrayList<Integer> traversalList = new ArrayList<>();

    int front = 0;

    void traverse(int[][] cost_matrix, int rootNode) {
        n = cost_matrix.length;
        this.visitedArray[rootNode] = true;
        traversalList.add(rootNode);
        if (someAreUnvisited(visitedArray)) {
            for (int i = 0; i < n; i++) {
                if (cost_matrix[rootNode][i] != max && !visitedArray[i]) {
                    traverse(cost_matrix, i);
                }
            }
        }
    }

    boolean someAreUnvisited(boolean[] arr) {
        for (boolean x : arr) {
            if (x == false) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] cost_matrix = new int[n][n];
        DFS dfs = new DFS(n);
        System.out.println("Enter the edge matrix. " + dfs.max + " is for not connected.");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost_matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    cost_matrix[i][j] = dfs.max;
                }
            }
        }

        System.out.print("Enter the node to start the traversal: ");
        int rootNode = scanner.nextInt();
        scanner.nextLine();
        scanner.close();

        dfs.traverse(cost_matrix, rootNode);
        System.out.println("Traversal using Depth First Search is " + (dfs.traversalList));
        if (dfs.someAreUnvisited(dfs.visitedArray)) {
            System.out.println("The graph is disjoint");
        } else
            System.out.println("All nodes are reachable");
    }
}
