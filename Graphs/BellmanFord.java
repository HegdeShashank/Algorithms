import java.util.List;

public class BellmanFord {
    static ShortestPath findShortestPath(Graph g, int source) {
        int[] weights = new int[g.vertex];
        initializeSingleSource(g,source, weights);
        return null;
    }

    public static void main(String[] args) {
        Graph graph = ConstructGraph.constructGraph();
        System.out.println(findShortestPath(graph, 0));

    }

    private static void initializeSingleSource(Graph g, int source, int[] weights) {
        for(int i=0;i<g.vertex;i++) {
            weights[i] = Integer.MAX_VALUE;
        }
        weights[source] = 0;
    }
}

class ShortestPath {
    int weight;
    List<Integer> path;
    ShortestPath(int weight, List<Integer> path) {
        this.weight = weight;
        this.path = path;
    }
}