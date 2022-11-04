public class FloydWarshall {
    final static int I = 99999, V = 4;

    void traverse(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        printSolution(dist);
    }



    void printSolution(int dist[][]) {
        System.out.println("SHORTEST PATH MATRIX:-");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == I)
                    System.out.print("I ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        int graph[][] = {{0, 5, I, 10}, {I, 0, 3, I}, {I, I, 0, 1}, {I, I, I, 0}};
        FloydWarshall a = new FloydWarshall();
        a.traverse(graph);
    }
}
