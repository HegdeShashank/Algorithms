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
        for(int i=0;i< graph.vertex; i++) {
            if(!visited[i]) {
                bfsOrder.addAll(bfsUtil(graph, i, visited));
            }
        }
        return bfsOrder;
    }

    public static void main(String[] args) {
        int V = 6;
        Graph graph = new Graph(V);
        graph.addEdge(0, 4);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        System.out.println(bfs(graph));
    }

}
