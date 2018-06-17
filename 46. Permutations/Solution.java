//46. Permutations
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        
        List<List<Integer>> result = new ArrayList();
        List<Integer> path = new ArrayList<Integer> ();
        traverse(result, nums, 0);
        
        return result;
    }
    
    private void traverse(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> ans = new ArrayList<Integer> ();
            for (int num : nums) {
                ans.add(num);
            }
            result.add(ans);
            return;
        }
        
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            traverse(result, nums, start + 1);
            swap(nums, start, i);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

