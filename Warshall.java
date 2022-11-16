import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge {
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
}


class Graph {
    List<List<Integer>> adjList = null;

    Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            int src = edges.get(i).source;
            int dest = edges.get(i).dest;

            adjList.get(src).add(dest);
        }
    }
}


public class Warshall {
    public static void DFS(Graph graph, boolean[][] C, int root, int descendant) {
        for (int child : graph.adjList.get(descendant)) {
            if (!C[root][child]) {
                C[root][child] = true;
                DFS(graph, C, root, child);
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of initial edges: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Source of edge " + (i + 1) + ": ");
            int source = scanner.nextInt();
            scanner.nextLine();
            System.out.print("It\'s destination: ");
            int destination = scanner.nextInt();
            scanner.nextLine();
            edges.add(new Edge(source, destination));
        }

        scanner.close();

        final int steps = n + 1;
        Graph graph = new Graph(edges, steps);
        boolean[][] C = new boolean[steps][steps];
        System.out.println("Transitive Closure: \n");
        for (int v = 0; v < steps; v++) {
            C[v][v] = true;
            DFS(graph, C, v, v);
            for (int u = 0; u < steps; u++)
                System.out.print(C[v][u] + " ");
            System.out.println();
        }
    }
}
