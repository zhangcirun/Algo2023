package Go2023;

import java.util.*;
 //        5
//    1       6
// 2   3
//post: 2 3 1 6 5
//queue: {2, 3, 6}
//{3 ,6} | 3 1 6 5
//{6, 1} | 1 6 5
//{6}    | 6 5
//{5}    | 5
//{}     | => valid path
//(do not use queue, use hashset

public class 课程表IVLint815 {
    public int topologicalSortNumber(int n, int[][] p) {
        // Write your code here
        Map<Integer, Set<Integer>> graph = buildGraph(n, p);
        Map<Integer, Integer> indegree = buildIndegree(n, graph);

        int ways = 1;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree.get(i) == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ways *= size;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                count++;
                for (int child : graph.get(node)) {
                    indegree.put(child, indegree.get(child) - 1);
                    if (indegree.get(child) == 0) {
                        queue.offer(child);
                    }
                }
            }
        }

        return count == n ? ways : 0;
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
