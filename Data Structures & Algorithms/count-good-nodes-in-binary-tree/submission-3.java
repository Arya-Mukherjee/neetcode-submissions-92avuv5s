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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    private int dfs(TreeNode node, int maxV){
        if (node == null)
            return 0;
        int count = 0;
        if(node.val>= maxV)
            count = 1;
        maxV = Math.max(node.val, maxV);
        count+= dfs(node.left, maxV);
        count+= dfs(node.right, maxV);
        return count;
    }
    
}
