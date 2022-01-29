import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    static List<Integer> bfs(Graph graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.vertex];
        List<Integer> bfsOrder = new ArrayList<>();
        bfsOrder.add(0);
        queue.add(0);
        for(int i = 0; i < graph.vertex; i++)
            visited[i] = false;
        visited[0] = true;
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

    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(5);
        graph.addEdge(0, 4);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.addEdge(3,4);
        graph.addEdge(4,1);
        System.out.println(bfs(graph));
    }
}
