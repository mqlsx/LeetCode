//102.Binary Tree Level Order Traversal
class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<> ();
		}

		List<List<Integer>> result = new ArrayList<> ();
		List<Integer> levelNodes = null;
		Queue<TreeNode> queue = new LinkedList<> ();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int len = queue.size();
			levelNodes = new ArrayList<> ();

			while (len > 0) {
				TreeNode currentNode = queue.poll();
				levelNodes.add(currentNode.val);
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
				len--;
			}

			result.add(levelNodes);
		}

		return result;
	}
}