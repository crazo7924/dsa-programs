// Java Program to Implement Dijkstra's Algorithm
// Using Priority Queue

// Importing utility classes
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// Main class DPQ
public class Dijkstra {

    class Node implements Comparator<Node> {

        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public Node() {}

        @Override
        public int compare(Node first, Node second) {
            return first.cost - second.cost;
        }
    }

    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;

    // Number of vertices
    private int V;
    List<List<Node>> adj;

    public Dijkstra(int V, List<List<Node>> adjecencyList) {
        this.V = V;
        this.adj = adjecencyList;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    public void dijkstra(int src) {


        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source node to the priority queue
        pq.add(new Node(src, 0));

        // Distance to the source is 0
        dist[src] = 0;

        while (settled.size() != V) {

            // Terminating condition check when
            // the priority queue is empty, return
            if (pq.isEmpty())
                return;

            // Removing the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            // Adding the node whose distance is
            // finalized
            if (settled.contains(u))

                // Continue keyword skips execution for
                // following check
                continue;

            // We don't have to call e_Neighbors(u)
            // if u is already present in the settled set.
            settled.add(u);

            processNeighbours(u);
        }
    }

    /**
     * 
     * @param u the node of which the neighbours are processed
     */
    private void processNeighbours(int u) {

        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            // If current node has already been processed, skip it.
            if (!settled.contains(v.node))
                continue;
            edgeDistance = v.cost;
            newDistance = dist[u] + edgeDistance;

            // If new distance is cheaper in cost
            if (newDistance < dist[v.node])
                dist[v.node] = newDistance;

            // Add the current node to the queue
            pq.add(new Node(v.node, dist[v.node]));
        }
    }

    public static void main(String args[]) {

        if(args.length != 2) return;

        int V = Integer.parseInt(args[1]);
        int source = Integer.parseInt(args[2]);

        // Adjacency list representation of the
        // connected edges by declaring List class object
        // Declaring object of type List<Node>
        List<List<Node>> adj = new ArrayList<List<Node>>();

        // Initialize list for every node
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Calculating the single source shortest path
        Dijkstra d = new Dijkstra(V, adj);
        d.dijkstra(source);

        // Printing the shortest path to all the nodes
        // from the source node
        System.out.println("The shortest path from node :");

        for (int i = 0; i < d.dist.length; i++)
            System.out.println(source + " to " + i + " is " + d.dist[i]);
    }
}
