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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        boolean isFullMatch = false;
        if(root.val == subRoot.val){
            isFullMatch = sameTree(subRoot, root);
        }

        return isFullMatch || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    public boolean sameTree(TreeNode subRoot, TreeNode root){
        if(subRoot == null && root == null) return true;
        if(subRoot == null || root == null) return false;

        boolean isLeftSame = sameTree(subRoot.left, root.left);
        boolean isRightSame = sameTree(subRoot.right, root.right);

        return isLeftSame && isRightSame && subRoot.val == root.val;
    }
}
