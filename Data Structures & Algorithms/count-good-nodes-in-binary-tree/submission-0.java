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
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }
    void dfs(TreeNode tree, int max){
        if(tree == null){
            return ;
        }
        if(tree.val >= max){
            count++;
            max = tree.val;
        }
        dfs(tree.left, max);
        dfs(tree.right, max);
    }
}
