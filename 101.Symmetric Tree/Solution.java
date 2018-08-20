//101. Symmetric Tree


class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return checkSymmetric(root.left, root.right);
	}

	private boolean checkSymmetric(TreeNode lNode, TreeNode rNode) {
		if (lNode == null && rNode == null) {
			return true;
		}

		if (lNode == null || rNode == null) {
			return false;
		}

		if (lNode.val != rNode.val) {
			return false;
		}

		return checkSymmetric(lNode.left, rNode.right)
			&& checkSymmetric(lNode.right, rNode.left);
	}
}