import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponent {

    static List<List<Integer>> findStronglyConnectedComponents(Graph graph) {
        List<List<Integer>> stronglyConnectedComponent = new LinkedList<>();
        Stack<Integer> orderOfVisitCompletion = findOrderOfVisitCompletion(graph);
        graph.invertGraph();
        while (!orderOfVisitCompletion.empty()) {
            int top = orderOfVisitCompletion.pop();
        }
        return stronglyConnectedComponent;
    }

    static Stack<Integer> findOrderOfVisitCompletion(Graph graph) {
        Stack<Integer> orderOfVisitCompletion = new Stack<>();
        boolean[] visited = new boolean[graph.vertex];
        for(int i=0; i<graph.vertex;i++) {
            if(!visited[i]) {
                dfsUtil(graph,visited,i,orderOfVisitCompletion);
            }
        }
        return orderOfVisitCompletion;
    }

    static void dfsUtil(Graph graph, boolean[] visited, int source, Stack<Integer> orderOfVisitCompletion) {
        visited[source] = true;
        orderOfVisitCompletion.push(source);
        ArrayList<Integer> adjacentNodes = graph.getAllConnectedVertexes(source);
        for(int node: adjacentNodes) {
            if(!visited[node]) {
                visited[node] = true;
                dfsUtil(graph, visited, node, orderOfVisitCompletion);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = ConstructGraph.constructGraph();
        System.out.println(findStronglyConnectedComponents(graph));
    }
}
