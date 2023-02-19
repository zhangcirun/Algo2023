package Go2023;
import java.util.*;

public class CourseScheduleII210Re {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = buildGraph(prerequisites);
        Map<Integer, Integer> indegree = buildInDegree(graph);

        System.out.println(graph);
        System.out.println(indegree);
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        List<Integer> path = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            path.add(node);
            for (int child : graph.get(node)) {
                indegree.put(child, indegree.get(child) - 1);
                if (indegree.get(child) == 0) {
                    queue.offer(child);
                }
            }
        }

        if (path.size() < numCourses) {
            return new int[] {};
        }

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = path.get(i);
        }
        return ans;
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int[] edge: prerequisites) {
            int parent = edge[1];
            int child = edge[0];
            if (!graph.containsKey(parent)) {
                graph.put(parent, new HashSet<>());
            }
            if (!graph.containsKey(child)) {
                graph.put(child, new HashSet<>());
            }
        }
        for (int[] edge: prerequisites) {
            int parent = edge[1];
            int child = edge[0];

            graph.get(parent).add(child);
        }

        return graph;
    }

    private Map<Integer, Integer> buildInDegree(Map<Integer, Set<Integer>> graph) {
        Map<Integer, Integer> indegree = new HashMap<>();

        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            int parent = entry.getKey();
            Set<Integer> children = entry.getValue();
            if (!indegree.containsKey(parent)) {
                indegree.put(parent, 0);
            }
            for (int child : children) {
                indegree.put(child, indegree.getOrDefault(child, 0) + 1);
            }
        }
        return indegree;
    }
}
