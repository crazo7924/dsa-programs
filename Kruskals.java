import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Kruskals {

    class Edge {
        int from;
        int to;
        int cost;
        boolean visited;

        Edge(int from, int to, int weight) {
            this.cost = weight;
            this.to = to;
            this.from = from;
            visited = false;
        }

        @Override
        public String toString() {
            return "Cost of edge (" + from + ", " + to + ") is " + cost;
        }
    }

    List<Edge> edgeList;
    List<Edge> MST;
    Comparator<Edge> byCost = new Comparator<Edge>() {

        @Override
        public int compare(Edge first, Edge second) {
            return first.cost - second.cost;
        }
    };

    public Kruskals() {
        edgeList = new ArrayList<>();
        MST = new ArrayList<>();
    }

    void traverse() {
        System.out.println("\nInput is");
        for (Edge edge : edgeList) {
            System.out.println(edge);
        }

        System.out.println("\nOutput is");

        edgeList.sort(byCost);

        for (Edge edge : edgeList) {
            if (noCyclePresent(edgeList, edge))
                MST.add(edge);
            edge.visited = true;
        }

        for (Edge edge : MST) {
            System.out.println(edge);
        }
    }

    private boolean noCyclePresent(List<Edge> edges, Edge inputEdge) {
        List<Edge> copiedEdges = new ArrayList<>(edges);
        for (Edge e : copiedEdges) {
            if (e.from == inputEdge.to)
                if (e.visited)
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kruskals kruskals = new Kruskals();
        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();

        for (int i = 0; i < edges; i++) {
            System.out.print("Enter destination of edge from " + (i + 1) + " : ");
            int dest = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter weight for edge (" + (i + 1) + ", " + dest + ") : ");
            int weight = scanner.nextInt();
            scanner.nextLine();

            kruskals.edgeList.add(kruskals.new Edge(i + 1, dest, weight));
            System.out.println();
        }
        scanner.close();

        kruskals.traverse();
    }
}
