import java.util.Scanner;

public class NodeDegree {

    // private method to input edge_matrix and output the degree array of nodes
    private static int[] getDegrees(int[][] cost_matrix) {
        int edges_count = cost_matrix.length;
        int[] degrees = new int[edges_count];

        for (int i = 0; i < edges_count; i++) {
            int degree = 0;
            for (int j = 0; j < edges_count; j++) {
                if (cost_matrix[i][j] != Integer.MAX_VALUE && cost_matrix[i][j] >= 0) {
                    degree++;
                }
            }
            degrees[i] = degree;
        }
        return degrees;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] cost_matrix = new int[n][n];

        System.out.println("Enter the edge adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost_matrix[i][j] = scanner.nextInt();
                scanner.nextLine();
                if (i == j) {
                    // set cost of self loops to max (infinity).
                    cost_matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        scanner.close();

        int[] cost_array = getDegrees(cost_matrix);
        for (int i = 0; i < n; i++) {
            System.out.println("the degree of node " + i + " is " + cost_array[i]);
        }
    }
}
