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
    private ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);       // Traverse left
            res.add(root.val);       // Visit root
            inOrder(root.right);      // Traverse right
        }

        return res;
    }
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return res.get(k-1);
    }
}