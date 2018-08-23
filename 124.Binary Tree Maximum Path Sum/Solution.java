//124.Binary Tree Maximum Path Sum
public class Solution {
    public static int maxPathSum(TreeNode root) {
            return findPathSum(root)[1];
        }

    private static int[] findPathSum(TreeNode root) {
        if (root == null) {
            return new int[] {0, Integer.MIN_VALUE};
        }

        int[] lValue = findPathSum(root.left);
        int[] rValue = findPathSum(root.right);

        // ret[0] is the value that must conatin root.val
        // ret[1] is the max value among this subtree with root
        int[] ret = {0, 0};
        ret[0] = Math.max(root.val, Math.max(root.val + lValue[0], root.val + rValue[0]));

        ret[1] = Math.max(Math.max(lValue[1], rValue[1]), ret[0]);
        ret[1] = Math.max(ret[1], root.val + lValue[0] + rValue[0]);

        return ret;
    }
}