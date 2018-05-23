366. Find Leaves of Binary Tree

public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList();
        }
        
        List<List<Integer>> result = new ArrayList();
        traverse(result, root);

        return result;
    }
    
    int traverse(List<List<Integer>> result, TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int l = traverse(result, root.left);
        int r = traverse(result, root.right);
        int level = Math.max(l, r);
        
        if (result.size() < level + 1) {
            List<Integer> list = new ArrayList<Integer> ();
            list.add(root.val);
            result.add(list);
        } else {
            List<Integer> list = result.get(level);
            list.add(root.val);
        }
        
        return level + 1;
    }
}
