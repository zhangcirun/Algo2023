package Go2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements347Sort {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();

        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
            list.add(new int[] {entry.getKey(), entry.getValue()});
        }

        list.sort((a, b) -> (b[1] - a[1])); //从大到小排序

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i)[0];
        }

        return ans;
    }
}
