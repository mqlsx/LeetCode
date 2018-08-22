//114.Faltten Binary Tree to Linked List
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<> ();
        TreeNode node = root;
        
        while (node != null || !stack.isEmpty()) {
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                node.right = node.left;
                node.left = null;
            } else if (!stack.isEmpty()) {
                node.right = stack.pop();
            }
            
            node = node.right;
        }
    }
}