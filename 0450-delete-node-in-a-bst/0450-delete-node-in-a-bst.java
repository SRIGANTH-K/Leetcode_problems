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
    public int replaceNode(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val<key){
            root.right = deleteNode(root.right,key);
        }
        else if (root.val>key){
            root.left = deleteNode(root.left,key);
        }
        else{
            //node has no child
            if (root.left == null && root.right == null){
                return null;
            }
            //node has only one child either left or right
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            //node has both child
            int temp = replaceNode(root.left);
            root.val = temp;
            root.left = deleteNode(root.left, temp);
        }
        return root;

    }
}