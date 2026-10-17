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
        dfs(root, sb);
        return sb.toString();
    }

    public void dfs(TreeNode root, StringBuilder sb){
        if(root == null){ 
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");

        dfs(root.left, sb);
        dfs(root.right, sb);
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
