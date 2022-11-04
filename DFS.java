import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

    List<Node> graph;

    class Node {
        char label;
        List<Character> neighbours;
        boolean visited;

        Node(char label, List<Character> neighbours) {
            this.label = label;
            this.neighbours = neighbours;
        }
    }

    DFS() {
        graph = new ArrayList<>();
        stack = new Stack<>();
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 2)
            System.exit(1);

        FileInputStream file = new FileInputStream(args[0]);
        Scanner scanner = new Scanner(file);
        DFS dfs = new DFS();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            char label = line.charAt(0);
            String row[] = line.substring(2).split(" ");
            List<Character> neighbours = new ArrayList<>();
            for (String s : row) {
                neighbours.add(s.charAt(0));
            }
            dfs.graph.add(dfs.new Node(label, neighbours));
        }
        scanner.close();
        dfs.search(args[1].charAt(0));
        System.out.println(dfs.stack);
    }

    Stack<Character> stack;

    void search(char root) {
        Node rootNode = getNodeByLabel(root);
        if (rootNode == null)
            return;
        if (!stack.contains(root))
            stack.push(root);
        for (Character n : rootNode.neighbours) {
            Node node = getNodeByLabel(n);
            if(node == null) continue;
            if (node.visited)
                continue;
            if (stack.contains(n))
                continue;
            stack.push(n);
            setVisited(n);
            search(n);
        }

    }

    private void setVisited(char label) {
        for (Node node : graph) {
            if (node.label == label) {
                node.visited = true;
                return;
            }
        }
    }

    private Node getNodeByLabel(char label) {
        for (Node node : graph) {
            if (node.label == label)
                return node;
        }
        return null;
    }
}
