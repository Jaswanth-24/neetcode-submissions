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
    int len = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return len ;
    }
    int dfs(TreeNode tree){
        if(tree == null){
            return 0;
        }
        int l = dfs(tree.left);
        int r = dfs(tree.right);
        len = Math.max(len, l + r);
        return 1 + Math.max(r, l);
    }
    
}
