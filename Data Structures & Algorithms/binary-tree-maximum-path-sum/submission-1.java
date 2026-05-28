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
 *         this.right = right
 ;
 *     }
 * }
 */

class Solution {
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return sum;
    }
    private int dfs(TreeNode node){
        if(node == null)    return 0;
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        int now = node.val + left+right;
        sum  = Math.max(now, sum);

        return node.val + Math.max(left, right); 
    }
}
