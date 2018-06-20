// 一个排好序的数组，每个元素出现两次， 只有一个出现一次， 要求找到这个只出现一次的数

public class FindSingleElement{
    public int findSingle(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int len = nums.length;
        int lo = 0;
        int hi = len - 1；
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 0) { // 如果是偶数位，在相等的那边
                if (nums[mid] == nums[mid - 1] {
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else { // 如果是奇数位，在不相等的那边
                if (nums[mid] == nums[mid - 1] {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        } // end of while
                    
        return nums[hi];
    }
}
