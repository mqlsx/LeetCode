//109.Convert Sorted List to Binary Search Tree
class Solution {
	private ListNode currentNode;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		int listSize = 0;
		ListNode node = head;
		while (node != null) {
			node = node.next;
			listSize++;
		}

		currentNode = head;

		TreeNode root = createBST(listSize);
		return root;
	}

	private TreeNode createBST(int listSize) {
		if (listSize <= 0) {
			return null;
		}

		TreeNode lNode = createBST(listSize / 2);
		TreeNode root = new TreeNode(currentNode.val);
		currentNode = currentNode.next;
		TreeNode rNode = createBST(listSize - listSize / 2 - 1);

		root.left = lNode;
		root.right = rNode;
		return root;
	}
}