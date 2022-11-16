import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Prims {
    class Vertex {
        int label;
        boolean visited = false;
        Map<Integer, Integer> neighbours;

        Vertex(int label, Map<Integer, Integer> neighbours) {
            this.label = label;
            this.neighbours = neighbours;
        }

        @Override
        public String toString() {
            String out = " to ->";
            for (Map.Entry<Integer, Integer> n : neighbours.entrySet()) {
                out += " " + n.getKey();
            }
            return label + out;
        }
    }

    List<Vertex> input, MST;
    int totalCost = 0;

    Vertex getVertexByLabel(int label) {
        for (Vertex vertex : input) {
            if (vertex.label == label)
                return vertex;
        }
        return null;
    }

    Vertex nextMinCostVertex(Vertex v) {
        if (v == null)
            return null;

        int cost = Integer.MAX_VALUE;
        Vertex min = null;

        for (Map.Entry<Integer, Integer> n : v.neighbours.entrySet()) {
            Vertex x = getVertexByLabel(n.getKey());
            if (n.getValue() < cost) {
                cost = n.getValue();
                min = x;
            }
        }

        if (cost != Integer.MAX_VALUE) {
            cost += cost;
            return min;
        }
        return null;

    }

    public Prims() {
        input = new ArrayList<>();
        MST = new ArrayList<>();
    }

    void traverse(int vertexLabel) {
        Vertex minVertex = getVertexByLabel(vertexLabel);
        if (minVertex == null)
            return;

        for (Map.Entry<Integer, Integer> n : minVertex.neighbours.entrySet()) {
            Vertex next = nextMinCostVertex(getVertexByLabel(n.getKey()));
            if (next == null)
                return;
            if (next.visited)
                continue;
            next.visited = true;

            traverse(next.label);
        }

    }

    static void print(List<Vertex> list) {
        for (Vertex vertex : list) {
            System.out.println(vertex);
        }
    }

    public static void main(String[] args) {
        Prims prims = new Prims();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        Map<Integer, Integer> neighbours = new HashMap<>();

        System.out.println("Enter adjecency lists as v1-c1 v2-c2 ...");
        for (int i = 1; i <= count; i++) {
            neighbours.clear();
            System.out.print("Vertex " + i + " : ");
            String[] list = scanner.nextLine().split(" ");
            for (String pair : list) {
                int label = Integer.parseInt(pair.split("-")[0]);
                int cost = Integer.parseInt(pair.split("-")[1]);
                neighbours.put(label, cost);
            }
            prims.input.add(prims.new Vertex(i, neighbours));
        }

        print(prims.input);

        System.out.print("Enter the start Vertex: ");
        int startVertex = scanner.nextInt();
        scanner.nextLine();

        prims.traverse(startVertex);

        scanner.close();

        print(prims.MST);
        System.out.println("Total cost: " + prims.totalCost);
    }
}
