// 669. Trim a Binary Search Tree

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        
        if (root.val < L) {
            return trimBST(root.right, L, R); 
        } else if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}