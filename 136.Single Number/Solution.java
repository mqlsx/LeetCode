//136.Single Number
class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        
        int ret = 0;
        for (int num : nums) {
            ret ^= num;
        }
        
        return ret;
    }

}
