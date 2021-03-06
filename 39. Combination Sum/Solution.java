// 39.Combination Sum



class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {

            return new ArrayList();

        }

        

        List<List<Integer>> result = new ArrayList();

        List<Integer> path = new ArrayList<Integer> ();

        //Arrays.sort(candidates);

        generate(result, path, candidates, target, 0);

        

        return result;

    }

    

    void generate(List<List<Integer>> result, List<Integer> path, int[] nums, int target, int start) {

        if (target < 0) {

            return;

        }

        if (target == 0) {

            result.add(new ArrayList<Integer> (path));

            return;

        }

        

        for (int i = start; i < nums.length; i++) {

            path.add(nums[i]);

            generate(result, path, nums, target - nums[i], i);

            path.remove(path.size() - 1);

        }

    }

}