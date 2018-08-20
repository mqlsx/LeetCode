//106.Construct Binary Tree from Inorder and Postorder Traversal
class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) {
			return null;
		}

		int inLen = inorder.length;
		int postLen = postorder.length;

		if (inLen == 0 || postLen == 0 || inLen != postLen) {
			return null;
		}

		return buildTree(inorder, 0, inLen - 1, postorder, 0, postLen - 1);
	}

	private TreeNode buildTree(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}

		int rootVal = post[postEnd];
		int inorderRootIdx = inStart;
		while (in[inorderRootIdx] != rootVal) {
			inorderRootIdx++;
		}

		int lTreeLen = inorderRootIdx - inStart;
		TreeNode root = new TreeNode(rootVal);
		root.left = buildTree(in, inStart, inorderRootIdx - 1, post, postStart, postStart + lTreeLen - 1);
		root.right = buildTree(in, inorderRootIdx + 1, inEnd, post, postStart + lTreeLen, postEnd - 1);

		return root;
	}
}