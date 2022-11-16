import java.util.ArrayList;
import java.util.Scanner;

public class BFS {
    int n;
    boolean[] visited;

    BFS(int n) {
        visited = new boolean[n];
    }

    ArrayList<Integer> traversalList = new ArrayList<>();

    int front = 0;

    void traverse(int[][] cost_matrix, int rootNode) {
        n = cost_matrix.length;
        this.visited[rootNode] = true;
        if (!traversalList.contains(rootNode))
            traversalList.add(rootNode);

        for (int i = 0; i < n; i++) {
            if (cost_matrix[rootNode][i] != 999 && !visited[i]) {
                if (!traversalList.contains(i))
                    traversalList.add(i);
            }
        }
        if (traversalList.size() > front + 1)
            traverse(cost_matrix, traversalList.get(++front));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = scanner.nextInt();

        int[][] costMatrix = new int[n][n];

        System.out.println("Enter the edge matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costMatrix[i][j] = scanner.nextInt();
                if (i == j) {
                    costMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        System.out.print("Enter the root node to beigin traversal: ");
        int rootNode = scanner.nextInt();
        scanner.nextLine();
        scanner.close();
        BFS bfs = new BFS(n);
        bfs.traverse(costMatrix, rootNode);
        System.out.println("Traversal order in breadth first search is " + (bfs.traversalList));
    }
}
