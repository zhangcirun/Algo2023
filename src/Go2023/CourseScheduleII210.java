package Go2023;

import java.util.*;

public class CourseScheduleII210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = buildGraph(numCourses, prerequisites);
        Map<Integer, Integer> nodeToIndegree = buildIndegree(numCourses, graph);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (nodeToIndegree.get(i) == 0) {
                queue.add(i);
            }
        }

        List<Integer> path = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            path.add(node);
            for (int child : graph.get(node)) {
                nodeToIndegree.put(child, nodeToIndegree.get(child) - 1);
                if (nodeToIndegree.get(child) == 0) {
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

    private Map<Integer, Set<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> parentToChild = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            parentToChild.put(i, new HashSet<>());
        }

        for (int[] edge: prerequisites) {
            int parent = edge[1];
            int child = edge[0];
            parentToChild.get(parent).add(child);
        }

        return parentToChild;
    }

    private Map<Integer, Integer> buildIndegree(int numCourses,  Map<Integer, Set<Integer>> parentToChild ) {
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
        }

        for (Set<Integer> children : parentToChild.values()) {
            for (int child : children) {
                indegree.put(child, indegree.get(child) + 1);
            }
        }

        return indegree;
    }
}
