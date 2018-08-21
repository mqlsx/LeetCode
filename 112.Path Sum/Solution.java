//112.Path Sum
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        return dfs(root, 0, sum);
    }
    
    private boolean dfs(TreeNode root, int pathSum, int sum) {
        if(root == null) {
            return false;
        }

        pathSum += root.val;
        if(sum == pathSum && root.left == null && root.right == null) {
            return true;
        }

        return dfs(root.left, pathSum, sum)
            || dfs(root.right, pathSum, sum);
    }
}