//104.Maximum Depth of Binary Tree
class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int lDepth = maxDepth(root.left);
		int rDepth = maxDepth(root.right);

		return Math.max(lDepth, rDepth) + 1;
	}
}