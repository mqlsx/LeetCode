//75. Sort Colors


public class Solution 
{
    public void sortColors(int[] nums) 
    {
        int red = 0;
        int blue = nums.length-1;
        
        for(int i=0; i<=blue; i++)
        {
            if(nums[i] == 0) // if find 0, swap with red pointer
            {
                int temp = nums[i];
                nums[i] = nums[red];
                nums[red] = temp;
                
                red++;
            }
            else if(nums[i] == 2) // if find 2, swap with blue pointer
            {
                int temp = nums[i];
                nums[i] = nums[blue];
                nums[blue] = temp;
                
                i--;
                blue--;
            }
       
        }
    }
}

