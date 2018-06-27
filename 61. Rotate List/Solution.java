//61. Rotate List

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) {
			return head;
		}
 
		int length = 1;
		ListNode node = head;
		while (node.next != null) {
			++length;
			node = node.next;
		}
 
		node.next = head;
 
		int m = n % length;
 
		for (int i = 0; i < length - m; ++i) {
			node = node.next;
		}
 
		head = node.next;
 
		node.next = null;
 
		return head;
    }
}

