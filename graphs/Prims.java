package graphs;

import java.util.List;
import java.util.Map;

public class Prims {
    Utils utils;

    List<Vertex> graph;

    public Prims(List<Vertex> graph) {
        this.graph = graph;
        utils = new Utils();
    }

    public void run() {

        if (graph.size() == 0)
            return;

        graph.get(0).visited = true;

        while (Utils.isDisconnected(graph)) {
            Edge nextMinimum = new Edge(Integer.MAX_VALUE);
            Vertex nextVertex = graph.get(0);
            for (Vertex vertex : graph) {
                if (vertex.visited) {
                    Map.Entry<Vertex, Edge> candidate = vertex.nextMinimum();
                    if (candidate.getValue().weight < nextMinimum.weight) {
                        nextMinimum = candidate.getValue();
                        nextVertex = candidate.getKey();
                    }
                }
            }
            nextMinimum.included = true;
            nextVertex.visited = true;
        }
        for (Vertex vertex : graph) {
            System.out.print("Vertex" + vertex.label + ": ");
            for (Edge edge : vertex.edges.values()) {
                System.out.print(edge.weight + " ");
            }
        }
    }
}
