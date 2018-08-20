//105.Construct Binary Tree from Preorder and Inorder Traversal
class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}

		int preLen = preorder.length;
		int inLen = inorder.length;

		if (preLen == 0 || inLen == 0 || preLen != inLen) {
			return null;
		}

		return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
	}

	private TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		int rootVal = pre[preStart];
		int inorderRootIdx = inStart;
		while (in[inorderRootIdx] != rootVal) {
			inorderRootIdx++;
		}

		int lTreeLen = inorderRootIdx - inStart;
		TreeNode root = new TreeNode(rootVal);
		root.left = buildTree(pre, preStart + 1, preStart + lTreeLen, in, inStart, inorderRootIdx - 1);
		root.right = buildTree(pre, preStart + lTreeLen + 1, preEnd, in, inorderRootIdx + 1, inEnd);

		return root;
	}
}