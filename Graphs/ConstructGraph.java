public class ConstructGraph {

    static Graph constructGraph() {
        int V = 6;
        Graph graph = new Graph(V);
        graph.addEdge(0, 4);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        return graph;
    }

}
