import java.util.ArrayList;

public class Graph {
    int vertex;
    ArrayList<ArrayList<Integer>> edges = new ArrayList<>(vertex);
    Graph(int vertex) {
        this.vertex = vertex;
        for (int i=0;i<vertex;i++) {
            edges.add(i, (new ArrayList<>()));
        }
    }

    void addEdge(int start, int end) {
        edges.get(start).add(end);
    }

    void invertGraph() {

    }

    ArrayList<Integer> getAllConnectedVertexes(int source) {
        return  edges.get(source);
    }
}
