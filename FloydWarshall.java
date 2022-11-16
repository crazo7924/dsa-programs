import java.util.Scanner;

class FloydWarshall {

    static final int INFINITE = 999;

    void run(int graph[][], int n) {
        int dist[][] = new int[n][n];
        int i, j, k;
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                dist[i][j] = graph[i][j];
        for (k = 0; k < n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        printSolution(dist, n);
    }

    void printSolution(int dist[][], int n) {
        System.out.println("Shorest path as matrix:");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dist[i][j] == INFINITE)
                    System.out.print("I ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = scanner.nextInt();

        int[][] cost_matrix = new int[n][n];

        System.out.println("Enter the cost matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost_matrix[i][j] = scanner.nextInt();
                if (i == j) {
                    cost_matrix[i][j] = 0;
                }
            }
        }
        scanner.close();

        FloydWarshall fw = new FloydWarshall();
        fw.run(cost_matrix, n);
    }
}
