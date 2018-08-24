//128.Longest Consecutive Sequence
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            
            int len = 1;
            int num = nums[i] + 1;
            while (set.contains(num)) {
                len++;
                num++;
            }
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
}