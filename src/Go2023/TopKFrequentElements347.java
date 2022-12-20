package Go2023;

import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }

        int[] uniques = new int[numToFreq.size()];
        int index = 0;
        for (int key : numToFreq.keySet()) {
            uniques[index++] = key;
        }
        return quickSelect(uniques, k - 1, 0, uniques.length - 1, numToFreq);
    }

    private int[] quickSelect(int[] nums, int k, int start, int end, Map<Integer, Integer> numToFreq) {
        int left = start;
        int right = end;

        int pivot = nums[start + (end - start) / 2];
        while (left <= right) {
            while (left <= right && numToFreq.get(nums[left]) > numToFreq.get(pivot)) {
                left++;
            }
            while (left <= right && numToFreq.get(nums[right]) < numToFreq.get(pivot)) {
                right--;
            }

            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        //start-----right----sorted----left---end
        if (k <= right) {
            return quickSelect(nums, k, start, right, numToFreq);
        }

        if (k >= left) {
            return quickSelect(nums, k, left, end, numToFreq);
        }

        int[] ans = new int[k + 1];
        int index = 0;
        for (int i = 0; i <= k; i++) {
            ans[index++] = nums[i];
        }
        return ans;
    }
}
