package Go2023;

public class CoinChangeII518 {
    public int change(int amount, int[] coins) {
        return dfs(amount, coins, 0, new Integer[amount + 1][coins.length]);
    }

    private int dfs(int amount, int[] coins, int index, Integer[][] memo) {
        if (amount < 0 || index >= coins.length) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        if (memo[amount][index] != null) {
            return memo[amount][index];
        }

        int useCoin = dfs(amount - coins[index], coins, index, memo);
        int noUseCoin = dfs(amount, coins, index + 1, memo);

        memo[amount][index] = useCoin + noUseCoin;
        return memo[amount][index];
    }
}

class CoinChangeII518完全背包 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        //横：目标钱的数量
        //纵：每个硬币的序号

        //对于使用前0个硬币，组成n个钱的方式为0
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        //对于0目标数量，使用任何数量的硬币都只有1种组合方式
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int coin = coins[i - 1]; //当前硬币
            for (int j = 1; j < dp[0].length; j++) { //j为当前容量
                if (coin <= j) {
                    dp[i][j] = dp[i][j - coin] + dp[i - 1][j];
                    //         |                          |
                    //         --> 使用该硬币1次或多次       ---->不用该硬币
                    //             not dp[i-1][j-coin]
                    //             because 可以用多次
                } else {
                    dp[i][j] = dp[i - 1][j]; //超过容量，不用该硬币
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}