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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerial(root, sb);
        return sb.toString();
    }

    private void dfsSerial(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        dfsSerial(node.left, sb);
        dfsSerial(node.right, sb);
    }
    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[] = data.split(",");
        return dfsdeSerial(arr);
    }
    private TreeNode dfsdeSerial(String arr[]){
        if(arr[index].equals("null")){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        root.left = dfsdeSerial(arr);
        root.right = dfsdeSerial(arr);
        return root;
    }
}
