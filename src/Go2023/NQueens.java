package Go2023;

import java.util.HashSet;
import java.util.Set;

public class NQueens {
    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        return dfs(n, 0, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int dfs(int n,
                    int numQueens,
                    int index,
                    Set<Integer> rowVisited,
                    Set<Integer> colVisited,
                    Set<Integer> diagonalVisited,
                    Set<Integer> antidiagVisited
    ) {
        if (n == numQueens) {
            return 1;
        }

        int x = index / n;
        int y = index % n;

        if (x >= n || y >= n) {
            return 0;
        }

        if (rowVisited.contains(x) || colVisited.contains(y) || diagonalVisited.contains(x + y) || antidiagVisited.contains(x - y)) {
            return dfs(n, numQueens, index + 1, rowVisited, colVisited, diagonalVisited, antidiagVisited);
        }
        int ans = 0;

        ans += dfs(n, numQueens, index + 1, rowVisited, colVisited, diagonalVisited, antidiagVisited);

        rowVisited.add(x);
        colVisited.add(y);
        diagonalVisited.add(x + y);
        antidiagVisited.add(x - y);
        ans += dfs(n, numQueens + 1, index + 1, rowVisited, colVisited, diagonalVisited, antidiagVisited);
        rowVisited.remove(x);
        colVisited.remove(y);
        diagonalVisited.remove(x + y);
        antidiagVisited.remove(x - y);

        return ans;
    }

//    public static void main(String[] args) {
//        System.out.println(new NQueens().totalNQueens(4));
//        System.out.println(new NQueens().totalNQueens(5));
//    }
}

//.  .  Q  .
//Q  .  .  .
//.  .  .  Q
//.  Q  .  .

//.  .  Q  .
//Q  .  .  .
//.  Q  .  .
//.  .  .  Q