package Go2023;

// [10, 5, 2, 6] k = 100
//  i
//      j

// [10, 5, 2, 6] k = 100
//  i
//         j
public class SubarrayProductLessThanK713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = nums[0];
        int count = 0;

        int j = 0; //let j be the last position that nums[i:j] < k
        for (int i = 0; i < nums.length; i++) {
            while (i > j || j < nums.length - 1 && nums[j + 1] * product < k) {
                j++;
                product *= nums[j];
            }
            if (product < k) {
                count += j - i + 1;
            }
            product /= nums[i];
        }

        return count;
    }


}
