//113.Path Sum II
class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) {
			return new ArrayList<> ();
		}

		List<List<Integer>> result = new ArrayList<> ();
		List<Integer> path = new ArrayList<> ();
		findPath(result, path, 0, root, sum);

		return result;
	}

	private void findPath(List<List<Integer>> result, List<Integer> path, int pathSum,
		TreeNode node, int target) {

		if (node == null) {
			return;
		}

		path.add(node.val);
		pathSum += node.val;

		if (node.left == null && node.right == null && pathSum == target) {
			result.add(new ArrayList<> (path));
			path.remove(path.size() - 1);
			return;
		}

		findPath(result, path, pathSum, node.left, target);
		findPath(result, path, pathSum, node.right, target);
		path.remove(path.size() - 1);
	}
}