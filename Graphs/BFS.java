import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    static List<Integer> bfsUtil(Graph graph, int source, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> bfsOrder = new ArrayList<>();
        bfsOrder.add(source);
        queue.add(source);
        visited[source] = true;
        while(queue.size() > 0) {
            int dequeue = queue.remove();
            ArrayList<Integer> adjacentNodes = graph.getAllConnectedVertexes(dequeue);
            for(int node: adjacentNodes) {
                if(!visited[node]) {
                    queue.add(node);
                    bfsOrder.add(node);
                    visited[node] = true;
                }
            }
        }
        return bfsOrder;
    }

    static List<Integer> bfs(Graph graph) {
        List<Integer> bfsOrder = new ArrayList<>();
        boolean[] visited = new boolean[graph.vertex];
        for(int i=0; i<graph.vertex; i++) {
            if(!visited[i]) {
                bfsOrder.addAll(bfsUtil(graph, i, visited));
            }
        }
        return bfsOrder;
    }

    public static void main(String[] args) {
        Graph graph = ConstructGraph.constructGraph();
        System.out.println(bfs(graph));
    }

}
