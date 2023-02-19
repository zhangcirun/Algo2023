package Go2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        dfs(board, 0, n, 0, ans, new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>());
        return ans;
    }


    private void dfs(char[][] board,
                     int index,
                     int n,
                     int numQueens,
                     List<List<String>> ans,
                     Set<Integer> visitedRows,
                     Set<Integer> visitedCols,
                     Set<Integer> visitedDiag,
                     Set<Integer> visitedAntiDiag
    ) {
        if (numQueens == n) {
            ans.add(boardToStr(board));
            return;
        }

        int x = index / board[0].length;
        int y = index % board[0].length;

        if (x >= board.length || y >= board[0].length) {
            return;
        }

        if (visitedRows.contains(x) || visitedCols.contains(y) || visitedDiag.contains(x + y) || visitedAntiDiag.contains(x - y)) {
            dfs(board, index + 1, n, numQueens, ans, visitedRows, visitedCols, visitedDiag, visitedAntiDiag);
            return;
        }

        dfs(board, index + 1, n, numQueens, ans, visitedRows, visitedCols, visitedDiag, visitedAntiDiag);

        board[x][y] = 'Q';
        visitedRows.add(x);
        visitedCols.add(y);
        visitedDiag.add(x + y);
        visitedAntiDiag.add(x - y);
        //System.out.println(boardToStr(board));
        dfs(board, index + 1, n, numQueens + 1, ans, visitedRows, visitedCols, visitedDiag, visitedAntiDiag);
        visitedRows.remove(x);
        visitedCols.remove(y);
        visitedDiag.remove(x + y);
        visitedAntiDiag.remove(x - y);
        board[x][y] = '.';
    }


    private List<String> boardToStr(char[][] board) {
        List<String> ans = new ArrayList<>();

        for (char[] rows : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : rows) {
                sb.append(c);
            }
            ans.add(sb.toString());
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new NQueens51().solveNQueens(4));
    }
}
