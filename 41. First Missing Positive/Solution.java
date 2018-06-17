//41. First Missing Positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        int length = segregate(nums);
        
        for (int i = 0; i < length; i++) {
            if (Math.abs(nums[i]) - 1 < length && nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }
    
    private int segregate(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}

