//103.Binary Tree Zigzag Level Order Traversal
class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList();
		}

		List<List<Integer>> result = new ArrayList<> ();
		List<Integer> levelNodes = new ArrayList<> ();
		Stack<TreeNode> forwardStack = new Stack<> ();
		Stack<TreeNode> backwardStack = new Stack<> ();

		forwardStack.push(root);

		while (!forwardStack.isEmpty() || !backwardStack.isEmpty()) {
			while (!forwardStack.isEmpty()) {
				TreeNode currentNode = forwardStack.pop();
				levelNodes.add(currentNode.val);
				if (currentNode.left != null) {
					backwardStack.push(currentNode.left);
				}
				if (currentNode.right != null) {
					backwardStack.push(currentNode.right);
				}
			}
			if (levelNodes.size() > 0) {
				result.add(levelNodes);
				levelNodes = new ArrayList<> ();
			}

			while (!backwardStack.isEmpty()) {
				TreeNode currentNode = backwardStack.pop();
				levelNodes.add(currentNode.val);
				if (currentNode.right != null) {
					forwardStack.push(currentNode.right);
				}
				if (currentNode.left != null) {
					forwardStack.push(currentNode.left);
				}
			}
			if (levelNodes.size() > 0) {
				result.add(levelNodes);
				levelNodes = new ArrayList<> ();
			}
		}

		return result;
	}
}