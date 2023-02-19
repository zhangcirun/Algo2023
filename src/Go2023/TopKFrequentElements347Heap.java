package Go2023;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347Heap {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToFreq = new HashMap<>();

        for (int num : nums) {
            numToFreq.put(num, numToFreq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry : numToFreq.entrySet()) {
            minHeap.offer(new int[] {entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = minHeap.poll()[0];
        }
        return ans;
    }
}
