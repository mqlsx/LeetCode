/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) {
            return null;
        }
        
        return buildTree(nums, 0, nums.length);
    }
    
    TreeNode buildTree(int[] nums, int start, int end) {
        if (end - start < 1) {
            return null;
        }

        // find max
        int maxIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = buildTree(nums, start, maxIndex);
        node.right = buildTree(nums, maxIndex + 1, end);
        
        return node;
    }
}
