package Go2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            System.out.println(i);
            System.out.println(nums[i]);
            twoSum(nums, -nums[i], i + 1, nums.length - 1, ans);
            System.out.println("=");
            System.out.println(ans);
            while (nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ans;
    }

    private void twoSum(int[] nums, int target, int start, int end, List<List<Integer>> ans) {
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(-target);
                tmp.add(nums[start]);
                tmp.add(nums[end]);
                ans.add(tmp);
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
    }

    public static void main(String[] args) {
        new ThreeSum15().threeSum(new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
    }
}
