package Go2023;

import java.util.List;
import java.util.Map;

public class MinimumTimeToMakeRopeColorful1578 {
    public int minCost(String colors, int[] neededTime) {
        if (colors.length() <= 1) {
            return 0;
        }

        return dfs(colors,  neededTime, 1, 0, new Integer[colors.length() + 1][colors.length() + 1]);
    }

    private int dfs(String colors, int[] neededTime, int index, int leftNeighborIndex, Integer[][] memo) {
        if (index == colors.length()) { //no need to remove the last bollon
            return 0;
        }
        if (memo[index][leftNeighborIndex] != null) {
            return memo[index][leftNeighborIndex];
        }
        //当前气球与前面的一个气球颜色相同
        if (colors.charAt(index) == colors.charAt(leftNeighborIndex)) {
            int removeCurrent = neededTime[index] + dfs(colors, neededTime, index + 1, leftNeighborIndex, memo);
            int removeLeft = neededTime[leftNeighborIndex] + dfs(colors, neededTime, index + 1, index, memo);
            memo[index][leftNeighborIndex] = Math.min(removeCurrent, removeLeft);
            return memo[index][leftNeighborIndex];
        }

        memo[index][leftNeighborIndex] = dfs(colors, neededTime, index + 1, index, memo);

        return memo[index][leftNeighborIndex];
    }

    //b_baaa
    //
}

class MinimumTimeToMakeRopeColorful1578_2  {
    public int minCost(String colors, int[] neededTime) {
        if (colors.length() <= 1) {
            return 0;
        }
        return dfs(colors, neededTime, 0, new Integer[colors.length()]);
    }

    private int dfs(String colors, int[] neededTime, int index, Integer[] memo) {
        if (index == neededTime.length - 1) {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        if (colors.charAt(index) == colors.charAt(index + 1)) {
            if (neededTime[index] < neededTime[index + 1]) {
                //remove current
                memo[index] = neededTime[index] + dfs(colors, neededTime, index + 1, memo);
                return memo[index];
            } else {
                //remove next
                int costToRemoveNext = neededTime[index + 1];
                neededTime[index + 1] = neededTime[index]; //swap ballon (color is same, but cost is diff)
                memo[index] = costToRemoveNext + dfs(colors, neededTime, index + 1, memo);
                return memo[index];
            }
        }

        memo[index] = dfs(colors, neededTime, index + 1, memo);
        return memo[index];
    }
    //* *      * *   * *   *
    //a a a  b b b a b b b b
    //3,5,10,7,5,3,5,5,4,8,1
    //3+5+5+3+5+4+1
}
