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
    public static int count;
    public static int answer;
    public void inOrder(TreeNode root, int k){
        if (root == null) return;
        inOrder(root.left, k);
        count++;
        if (k == count){
            answer = root.val;
            return;
        }
        inOrder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        answer = 0;
        inOrder(root,k);
        return answer;
    }
}