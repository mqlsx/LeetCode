//47. Permutations II


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        List<Integer> path = new ArrayList<Integer> ();
        boolean[] isUsed = new boolean[nums.length];
        dfs(result, path, nums, isUsed);
        
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> path, int[] nums, boolean[] isUsed) {
        if (path.size() == nums.length) {
            result.add(new ArrayList(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i] == true || (i > 0 && nums[i] == nums[i - 1] && isUsed[i - 1] == false)) {
                continue;
            }
            path.add(nums[i]);
            isUsed[i] = true;
            dfs(result, path, nums, isUsed);
            path.remove(path.size() - 1);
            isUsed[i] = false;
        }
    }
}

