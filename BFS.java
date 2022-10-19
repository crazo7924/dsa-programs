import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    class Node {
        char label;
        boolean visited;

        Node(char label) {
            this.label = label;
        }
    }

    Map<Character, List<Node>> graph;

    BFS() {
        graph = new HashMap<>();
        queue = new ArrayDeque<>();
    }

    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream file = new FileInputStream(args[0]);
        Scanner scanner = new Scanner(file);
        BFS bfs = new BFS();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char label = line.charAt(0);
            String row[] = line.substring(2).split(" ");
            List<Node> neighbours = new ArrayList<>();
            for (String s : row) {
                neighbours.add(bfs.new Node(s.charAt(0)));
            }
            bfs.graph.put(label, neighbours);
        }
        scanner.close();
        bfs.search('5');
        System.out.println(bfs.queue);
    }

    Queue<Character> queue;

    void search(char root) {
        for (Node node : graph.get(root)) {
            if (node.visited || queue.contains(node.label))
                continue;
            queue.add(node.label);
            search(node.label);
        }
    }
}
