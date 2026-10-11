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
    int result = Integer.MIN_VALUE;
    boolean found = false;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return result;
    }

    public void dfs(TreeNode node, int k) {
        if (node == null || found)
            return;

        dfs(node.left, k);

        if(found) return;

        count++;
        if (count == k) {
            result = node.val;
            found = true;
            return;
        }

        dfs(node.right, k);
    }
}
