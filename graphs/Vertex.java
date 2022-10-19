package graphs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Vertex {

    String label;
    Map<Vertex, Edge> edges = new HashMap<>();
    boolean visited;

    public Vertex(String label) {
        this.label = label;
    }

    public void addEdge(Vertex vertex, Edge edge) {
        if (edges.containsKey(vertex)) {
            if (edge.weight < edges.get(vertex).weight) {
                edges.replace(vertex, edge);
            }
        } else {
            this.edges.put(vertex, edge);
        }
    }

    public Map.Entry<Vertex, Edge> nextMinimum() {
        Edge nextMinimum = new Edge(Integer.MAX_VALUE);
        Vertex nextVertex = this;
        Iterator<Map.Entry<Vertex, Edge>> it = edges.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Vertex, Edge> pair = it.next();
            if (!pair.getKey().visited) {
                if (!pair.getValue().included) {
                    if (pair.getValue().weight < nextMinimum.weight) {
                        nextMinimum = pair.getValue();
                        nextVertex = pair.getKey();
                    }
                }
            }
        }
        return Map.entry(nextVertex, nextMinimum);
    }

    public String originalToString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Vertex, Edge>> it = edges.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Vertex, Edge> pair = it.next();
            if (!pair.getValue().printed) {
                sb.append(label);
                sb.append(" --- ");
                sb.append(pair.getValue().weight);
                sb.append(" --- ");
                sb.append(pair.getKey().label);
                sb.append("\n");
                pair.getValue().printed = true;
            }
        }
        return sb.toString();
    }

    public String includedToString() {
        StringBuilder sb = new StringBuilder();
        if (visited) {
            Iterator<Map.Entry<Vertex, Edge>> it = edges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Vertex, Edge> pair = it.next();
                if (pair.getValue().included) {
                    if (!pair.getValue().printed) {
                        sb.append(label);
                        sb.append(" --- ");
                        sb.append(pair.getValue().weight);
                        sb.append(" --- ");
                        sb.append(pair.getKey().label);
                        sb.append("\n");
                        pair.getValue().printed = true;
                    }
                }
            }
        }
        return sb.toString();
    }
}
