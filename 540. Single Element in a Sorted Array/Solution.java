// 540. Single Element in a Sorted Array

public class Solution {  
    public int singleNonDuplicate(int[] nums) {  
        int low = 0;  
        int high = nums.length / 2;  
        while(low < high){  
            int mid = low + (high - low) / 2;  
            if(nums[2 * mid] != nums[2 * mid + 1]){  
                high = mid;  
            }else{  
                low = mid + 1;  
            }  
        }  
        return nums[2 * low];  
    }  
}  