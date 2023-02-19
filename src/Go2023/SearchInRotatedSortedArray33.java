package Go2023;

public class SearchInRotatedSortedArray33 {
    //[4,5,6,7,0,1,2]
    //[1,2,3,4,5]
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[nums.length - 1]) { //left side
                if (nums[mid] > target && target > nums[nums.length - 1]) {
                    end = mid;
                } else if (nums[mid] > target && target <= nums[nums.length - 1]) {
                    start = mid;
                } else { //nums[mid] < target
                    start = mid;
                }
            } else {  //right side
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    start = mid;
                } else if (nums[mid] < target && target > nums[nums.length - 1]) {
                    end = mid;
                } else { //nums[mid] > target
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
