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
    private int dfs(TreeNode node, int maxv){
        if(node == null)
            return 0;
        int count = 0;
        if(node.val>=maxv)
            count  = 1;
        maxv = Math.max(maxv, node.val);
        count += dfs(node.left, maxv);
        count+=dfs(node.right, maxv);
        return count;
    }
}
