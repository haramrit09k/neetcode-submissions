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
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);
    }
    // preorder is original preorder array
    // l and r are boundaries of inorder array - we created map
    // so we dont have to create copy of it again and again
    // Note: l and r are BOTH INCLUSIVE i.e. those indices are counted as part of the array
    public TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r)
            return null;

        int val = preorder[preIndex];
        preIndex++;

        int mid = map.get(val);

        TreeNode root = new TreeNode(val);
        root.left = dfs(preorder, l, mid - 1);
        root.right = dfs(preorder, mid + 1, r);

        return root;
    }
}
