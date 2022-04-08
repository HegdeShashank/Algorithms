import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class CycleDetection {
    static boolean detectCycleInGraph(Graph g) {
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> orderOfVisitCompletion = new Stack<>();
        boolean[] visited = new boolean[g.vertex];
        boolean hasCycle = false;
        for(int i=0;i< g.vertex; i++) {
            if(!visited[i]) {
                hasCycle = hasCycle || dfsUtil(g, visited, i, orderOfVisitCompletion, set);
            }
        }
        return hasCycle;
    }

    static boolean dfsUtil(
            Graph graph,
            boolean[] visited,
            int source,
            Stack<Integer> orderOfVisitCompletion,
            HashSet<Integer> set
    ) {
        visited[source] = true;
        orderOfVisitCompletion.push(source);
        ArrayList<Integer> adjacentNodes = graph.getAllConnectedVertexes(source);
        for(int node: adjacentNodes) {
            if(!visited[node]) {
                visited[node] = true;
                return dfsUtil(graph, visited, node, orderOfVisitCompletion, set);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = ConstructGraph.constructGraph();
        System.out.println(detectCycleInGraph(graph));
    }
}
