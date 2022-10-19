package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kruskals {

    List<Vertex> graph;
    Set<Edge> edges;
    Utils utils;

    public Kruskals(List<Vertex> graph) {
        this.graph = graph;
        edges = new HashSet<>(graph.size() - 1);
        for (Vertex vertex : graph) {
            edges.addAll(vertex.edges.values());
        }
    }

    public void run() {
        if (graph.size() == 0)
            return;

        List<Vertex> mst = new ArrayList<>();
        mst.addAll(graph);

        for (Vertex vertex : mst) {
            vertex.visited = false;
            vertex.edges.clear();
        }

        Edge candidateEdge = getMinEdge();
        while (candidateEdge.weight < Integer.MAX_VALUE) {
            if (mst.size() + 1 == graph.size())
                break;
            for (Vertex vertex : mst) {
                vertex.addEdge(vertex, candidateEdge);
            }
        }

        for (Vertex vertex : graph) {
            System.out.print("Vertex" + vertex.label + ": ");
            for (Edge edge : vertex.edges.values()) {
                System.out.print(edge.weight + " ");
            }
        }
    }

    private Edge getMinEdge() {
        Edge minimumEdge = new Edge(Integer.MAX_VALUE);

        for (Edge edge : edges) {
            if (minimumEdge.weight > edge.weight)
                minimumEdge = edge;
        }
        edges.remove(minimumEdge);
        return minimumEdge;
    }
}
