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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long lowerBound, long upperBound){
        if(root == null) return true;

        if(root.val >= upperBound || root.val <= lowerBound) return false;

        boolean leftRes = dfs(root.left, lowerBound, root.val);
        boolean rightRes = dfs(root.right, root.val, upperBound);

        return leftRes && rightRes;
    }
}
