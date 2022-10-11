import java.util.List;

public class TopologicalSort {
    static List<Integer> topologicalSort(Graph g) {
        return DFS.dfs(g);
    }
}
