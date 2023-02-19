package Go2023;

public class HouseRobber198 {
    public int rob(int[] nums) {
        return dfs(nums, 0, new Integer[nums.length]);
    }

    private int dfs(int[] nums, int index, Integer[] memo) {
        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        int robProfit = nums[index] + dfs(nums, index + 2, memo);
        int noRobProfit = dfs(nums, index + 1, memo);

        memo[index] = Math.max(robProfit, noRobProfit);
        return memo[index];
    }
}

class HouseRobber198Iterarive {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = 0; i < dp.length; i++) {
            int rob = nums[i] + (i - 2 >= 0 ? dp[i - 2] : 0);
            int noRob = i - 1 >= 0 ? dp[i - 1] : 0;
            dp[i] = Math.max(rob, noRob);
        }
        return dp[dp.length - 1];
    }
}
