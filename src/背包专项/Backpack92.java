package 背包专项;

public class Backpack92 {
    //每个物品只能选择一次
    public int backPack(int m, int[] a) {
        // write your code here
        if (m == 0) {
            return 0;
        }
        return dfs(0, 0, a, m, new Integer[m][a.length]);
    }

    private int dfs(int weight, int index, int[] list, int capacity, Integer[][] memo) {
        if (weight == capacity) { //正好装满
            return weight;
        }

        if (weight > capacity) {  //超重了，拿出去一个返回最大重量
            return weight - list[index - 1];
        }

        if (index >= list.length) { //想装的全装进去背包还没满
            return weight;
        }

        if (memo[weight][index] != null) {
            return memo[weight][index];
        }

        int put = dfs(weight + list[index], index + 1, list, capacity, memo);
        int notPut = dfs(weight, index + 1, list, capacity, memo);

        memo[weight][index] = Math.max(put, notPut);
        return memo[weight][index];
    }
}
