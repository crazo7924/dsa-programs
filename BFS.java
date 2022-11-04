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

    Map<Character, List<Character>> graph;

    BFS() {
        graph = new HashMap<>();
        queue = new ArrayDeque<>();
    }

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length != 2)
            return;
        FileInputStream file = new FileInputStream(args[0]);
        Scanner scanner = new Scanner(file);
        BFS bfs = new BFS();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char label = line.charAt(0);
            String row[] = line.substring(2).split(" ");
            List<Character> neighbours = new ArrayList<>();
            for (String s : row) {
                neighbours.add(s.charAt(0));
            }
            bfs.graph.put(label, neighbours);
        }
        scanner.close();
        bfs.search(args[1].charAt(0));
        System.out.println(bfs.queue);
    }

    Queue<Character> queue;

    void search(char root) {
        if (graph.get(root) == null)
            return;
        if (!queue.contains(root))
            queue.add(root);
        for (Character node : graph.get(root)) {
            if (node == null)
                continue;
            if (queue.contains(node))
                continue;
            queue.add(node);
            search(node);
        }
    }
}
