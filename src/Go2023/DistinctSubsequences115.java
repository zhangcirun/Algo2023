package Go2023;

public class DistinctSubsequences115 {
    public int numDistinct(String s, String t) {
        return dfs(s, t, 0, 0, new Integer[s.length() + 1][t.length() + 1]);
    }

    private int dfs(String source, String target, int indexS, int indexT, Integer[][] memo) {
        if (memo[indexS][indexT] != null) {
            return memo[indexS][indexT];
        }

        if (indexT == target.length()) {
            return 1;
        }
        if (indexS == source.length()) {
            return 0;
        }

        int ways = 0;
        if (source.charAt(indexS) == target.charAt(indexT)) {
            ways += dfs(source, target, indexS + 1, indexT + 1, memo);
        }

        ways += dfs(source, target, indexS + 1, indexT, memo);

        memo[indexS][indexT] = ways;
        return ways;
    }
}
