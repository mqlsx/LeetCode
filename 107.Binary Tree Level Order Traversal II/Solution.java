//107.Binary Tree Level Order Traversal II
class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if (root == null) {
			return new ArrayList();
		}

		LinkedList<List<Integer>> result = new LinkedList<> ();
		List<Integer> levelNodes = new ArrayList<> ();
		Queue<TreeNode> queue = new LinkedList<> ();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size > 0) {
				TreeNode node = queue.poll();
				levelNodes.add(node.val);

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				size--;
			}
			result.addFirst(levelNodes);
			levelNodes = new ArrayList<> ();
		}

		return result;
	}
}