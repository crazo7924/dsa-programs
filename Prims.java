import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Prims {
    class Vertex {
        Character label;
        boolean visited = false;
        Map<Integer, Character> neighbours;

        Vertex(Character label, Map<Integer, Character> neighbours) {
            this.label = label;
            this.neighbours = neighbours;
        }

        @Override
        public String toString() {
            String out = " to ->";
            for (Entry<Integer, Character> n : neighbours.entrySet()) {
                out += " " + n.getValue();
            }
            return label + out;
        }
    }

    List<Vertex> input, MST;
    int mstCost = 0;

    Vertex getVertexByLabel(char label) {
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
        for (Entry<Integer, Character> n : v.neighbours.entrySet()) {
            Vertex x = getVertexByLabel(n.getValue());
            if (n.getKey() < cost) {
                cost = n.getKey();
                min = x;
            }
        }
        if (cost != Integer.MAX_VALUE) {
            mstCost += cost;
            return min;
        }
        return null;

    }

    public Prims() {
        input = new ArrayList<>();
        MST = new ArrayList<>();
    }

    void addVertex(char label, Map<Integer, Character> neighbours) {
        input.add(new Vertex(label, neighbours));
    }

    void start(char start) {
        Vertex s = null;
        for (Vertex vertex : input) {
            if (vertex.label == start)
                s = vertex;
        }
        if (s == null) {
            System.err.println("Invalid start vertex");
            return;
        }

        s.visited = true;
        traverse(nextMinCostVertex(s));
    }

    void traverse(Vertex minVertex) {
        if (minVertex == null)
            return;

        if (minVertex.visited)
            traverse(nextMinCostVertex(minVertex));
        else
            return;

        for (Entry<Integer, Character> n : minVertex.neighbours.entrySet()) {
            Vertex next = nextMinCostVertex(getVertexByLabel(n.getValue()));
            if (next != null)
                next.visited = true;
            else
                traverse(next);
        }

    }

    void printMST() {
        for (Vertex vertex : MST) {
            System.out.println(vertex);
        }
    }

    void printInput() {
        for (Vertex vertex : input) {
            System.out.println(vertex);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Prims prims = new Prims();
        FileInputStream file = new FileInputStream(args[0]);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char label = line.charAt(0);
            Map<Integer, Character> neighbours = new HashMap<>();
            for (int i = 2; i < line.length() - 2; i += 4) {
                neighbours.put((int) line.charAt(i), line.charAt(i + 2));
            }
            prims.addVertex(label, neighbours);
        }
        scanner.close();
        prims.printInput();

        prims.start('A');
        prims.printMST();
        System.out.println("Total cost: " + prims.mstCost);
    }
}
