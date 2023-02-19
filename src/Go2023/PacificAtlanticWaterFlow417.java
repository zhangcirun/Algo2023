package Go2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow417 {
    int[] dx = new int[] {0, 0, -1, 1};
    int[] dy = new int[] {1, -1, 0, 0};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacificVisited = pacificFlow(heights);
        boolean[][] atlanticVisited = atlanticFlow(heights);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    List<Integer> cord = new ArrayList<>();
                    cord.add(i);
                    cord.add(j);
                    ans.add(cord);
                }
            }
        }
        return ans;
    }

    private boolean[][] pacificFlow(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 1; i < m; i++) {
            visited[i][0] = true;
            queue.offer(new int[] {i, 0});
        }

        for (int i = 1; i < n; i++) {
            visited[0][i] = true;
            queue.offer(new int[] {0, i});
        }

        visited[0][0] = true;
        queue.offer(new int[] {0, 0});


        //bfs
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (!isValid(heights, visited, x, y, newX, newY)) {
                    continue;
                }
                visited[newX][newY] = true;
                queue.offer(new int[] {newX, newY});
            }

        }
        return visited;
    }

    private boolean[][] atlanticFlow(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m - 1; i++) {
            visited[i][n - 1] = true;
            queue.offer(new int[] {i, n - 1});
        }

        for (int i = 0; i < n - 1; i++) {
            visited[m - 1][i] = true;
            queue.offer(new int[] {m - 1, i});
        }

        visited[m - 1][n - 1] = true;
        queue.offer(new int[] {m - 1, n - 1});

        //bfs
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (!isValid(heights, visited, x, y, newX, newY)) {
                    continue;
                }
                visited[newX][newY] = true;
                queue.offer(new int[] {newX, newY});
            }
        }
        return visited;
    }
    private boolean isValid(int[][] heights,
                            boolean[][] visited,
                            int x,
                            int y,
                            int newX,
                            int newY) {
        if (newX < 0 || newY < 0 || newX >= heights.length || newY >= heights[0].length) {
            return false;
        }

        if (visited[newX][newY]) {
            return false;
        }

        return heights[newX][newY] <= heights[x][y];
    }
}
