package Go2023;

public class JumpGameII45 {
    public int jump(int[] nums) {
        return dfs(nums, 0, new Integer[nums.length + 1]);
    }

    private int dfs(int[] nums, int index, Integer[] memo) {
        if (index >= nums.length) {
            return Integer.MAX_VALUE;
        }

        if (index == nums.length - 1) {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        int step = nums[index];

        int minStep = Integer.MAX_VALUE;
        for (int i = 1; i <= step; i++) {
            int tmp =  dfs(nums, index + i, memo);
            if (tmp == Integer.MAX_VALUE) {
                continue;
            }
            minStep = Math.min(minStep, tmp + 1);
        }

        memo[index] = minStep;
        return minStep;
    }
}
