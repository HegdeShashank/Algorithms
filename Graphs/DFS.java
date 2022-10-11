import java.util.ArrayList;
import java.util.List;

public class DFS {
    static void dfsUtil(Graph graph, int source, boolean[] visited, List<Integer> dfsOrder) {
        dfsOrder.add(source);
        visited[source] = true;
        ArrayList<Integer> adjacentNodes = graph.getAllConnectedVertexes(source);
        for(int node: adjacentNodes) {
            if(!visited[node]) {
                visited[node] = true;
                dfsUtil(graph, node, visited, dfsOrder);
            }
        }
    }
     static List<Integer> dfs(Graph graph) {
         List<Integer> dfsOrder = new ArrayList<>();
         boolean[] visited = new boolean[graph.vertex];
         for(int i=0;i< graph.vertex; i++) {
             if(!visited[i]) {
                 dfsUtil(graph, i, visited, dfsOrder);
             }
         }
         return dfsOrder;
     }

    public static void main(String[] args) {
        Graph graph = ConstructGraph.constructGraph();
        System.out.println(dfs(graph));
    }
}
