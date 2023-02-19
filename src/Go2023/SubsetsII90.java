package Go2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//[1,1,2,2,3]

//                      []
//            [1]                [2]             [3]
//     [1,1]           [1,2]           [2,2] [2,3]
//[1,1,2] [1,1,3]  [1,2,2] [1,2,3]
public class SubsetsII90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }


    private void dfs(int[] nums,
                     int index,
                     List<Integer> combination,
                     List<List<Integer>> combinations) {

        combinations.add(new ArrayList<>(combination));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            combination.add(nums[i]);
            dfs(nums, i + 1, combination, combinations);
            combination.remove(combination.size() - 1);
        }
    }

}
