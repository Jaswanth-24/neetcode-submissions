/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean bal = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return bal;
    }
    int dfs(TreeNode tree){
        if(tree == null){
            return 0;
        }
        int l = 0, r = 0;
        l = dfs(tree.left);
        r = dfs(tree.right);
        if(Math.abs(l - r) > 1){
            bal = false;
        }
        return 1 + Math.max(r, l);
    }
}
