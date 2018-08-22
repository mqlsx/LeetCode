//117.Populating Next Right Pointers in Each Node II
class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		TreeLinkNode node = root.next;

		while (node != null) {
			if (node.left != null) {
				node = node.left;
				break;
			} else if (node.right != null) {
				node = node.right;
				break;
			}

			node = node.next;
		}

		if (root.right != null) {
			if (root.left != null) {
				root.left.next = root.right;
			}
			root.right.next = node;		
		} else {
			if (root.left != null) {
				root.left.next = node;
			}
		}

		connect(root.right);
		connect(root.left);
	}
}