//138.Copy List with Random Pointer
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode current = head;
        while (current != null) {
            // insert the copy node after current
            RandomListNode copyNode = new RandomListNode(current.label);
            copyNode.next = current.next;
            current.next = copyNode;
            
            current = current.next.next;
        }
        
        current = head;
        RandomListNode currentNext = head.next;
        while (current != null) {
            currentNext.random = current.random == null ? null : current.random.next;
            if (currentNext.next != null) {
                current = currentNext.next;
                currentNext = current.next;
            } else {
                current = null;
            }  
        }
        
        
        current = head;
        currentNext = head.next;
        RandomListNode copyHead = head.next;
        while (current != null) {
            if (currentNext.next != null) {
                current.next = currentNext.next;
                currentNext.next = currentNext.next.next;
                
                current = current.next;
                currentNext = currentNext.next;
            } else {
                current.next = null;
                current = current.next;
            }
        }
        
        return copyHead;
    }
}