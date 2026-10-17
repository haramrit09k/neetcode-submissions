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
        // System.out.println(dfs(root));
        return dfs(root);
    }

    public String dfs(TreeNode root){
        if(root == null) return "N,";

        String val = String.valueOf(root.val);
        return val + "," + dfs(root.left) + dfs(root.right);
    }

    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        String[] tokens = data.split(",");

        return build(tokens);
    }

    private TreeNode build(String[] tokens){
        // if(tokens.length == 0 || tokens == null) return null;

        String curr = tokens[index];
        index++;
        if(curr.equals("N")) return null;

        TreeNode currNode = new TreeNode(Integer.valueOf(curr));
        currNode.left = build(tokens);
        currNode.right = build(tokens);

        return currNode;
    }
}
