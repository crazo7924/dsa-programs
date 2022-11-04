import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Kruskals {

    class Edge {
        char from;
        char to;
        int weight;
        boolean visited;

        Edge(char from, char to, int weight) {
            this.weight = weight;
            this.to = to;
            this.from = from;
            visited = false;
        }

        @Override
        public String toString() {
            return to + "\t" + from + "\t" + weight;
        }
    }

    List<Edge> edgeList;
    List<Edge> MST;
    Comparator<Edge> comparator = new Comparator<Edge>() {

        @Override
        public int compare(Edge first, Edge second) {
            return first.weight - second.weight;
        }
    };

    public Kruskals() {
        edgeList = new ArrayList<>();
        MST = new ArrayList<>();
    }

    void traverse() {
        System.out.println("\tInput");
        System.out.println("From\tTo\tWeight");
        for (Edge edge : edgeList) {
            System.out.println(edge);
        }

        System.out.println("\n\tOutput");

        Collections.sort(edgeList, comparator);

        for (Edge edge : edgeList) {
            if (noCyclePresent(edgeList, edge))
                MST.add(edge);
            edge.visited = true;
        }

        System.out.println("From\tTo\tWeight");
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

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream(args[0]);
        Scanner scanner = new Scanner(file);
        Kruskals kruskals = new Kruskals();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char from = line.charAt(0);
            char to = line.charAt(2);
            int weight = Integer.parseInt(line.substring(4));
            kruskals.addEdge(from, to, weight);
        }
        scanner.close();

        kruskals.traverse();
    }

    void addEdge(char from, char to, int weight) {
        edgeList.add(new Edge(from, to, weight));
    }
}
