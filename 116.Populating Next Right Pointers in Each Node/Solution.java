//116.Populating Next Right Pointers in Each Node
class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		TreeLinkNode node = root.next;

		if (node != null) {
			if (root.left != null) {
				root.left.next = root.right;
			}
			
			if (node.right != null) {
				root.right.next = node.left;
			}
		} else {
			if (root.left != null) {
				root.left.next = root.right;
			}

			if (root.right != null) {
				root.right.next = null;
			}
		}

		connect(root.left);
		connect(root.right);
	}
}