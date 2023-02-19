package Go2023;

import java.util.ArrayList;
import java.util.List;


public class AllPathsFromSourceToTarget797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPath = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);

        dfs(graph, 0, graph.length - 1, path, allPath);
        return allPath;
    }

    private void dfs(int[][] graph,
                     int curr,
                     int target,
                     List<Integer> path,
                     List<List<Integer>> allPath) {
        if (curr == target) {
            allPath.add(new ArrayList<>(path));
            return;
        }

        for (int child: graph[curr]) {
            path.add(child);
            dfs(graph, child, target, path, allPath);
            path.remove(path.size() - 1);
        }
    }
}
