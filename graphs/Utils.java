package graphs;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    static String graphToString(List<Vertex> graph) {
        StringBuilder sb = new StringBuilder();
        for (Vertex vertex : graph) {
            sb.append(vertex.label);
        }
        return sb.toString();
    }

    static boolean isDisconnected(List<Vertex> graph) {
        for (Vertex vertex : graph) {
            if (!vertex.visited) {
                return true;
            }
        }
        return false;
    }

    static List<Vertex> costMatrixToGraph(int costMatrix[][]) {
        List<Vertex> graph = new ArrayList<>();
        for (int i = 0; i < costMatrix.length; i++) {
            Vertex vertex = new Vertex(String.valueOf(i));
            for (int j = 0; j < costMatrix[i].length; j++) {
                if (costMatrix[i][j] != Integer.MAX_VALUE)
                    vertex.addEdge(vertex, new Edge(costMatrix[i][j]));
            }
            graph.add(vertex);
        }
        return graph;
    }
}
