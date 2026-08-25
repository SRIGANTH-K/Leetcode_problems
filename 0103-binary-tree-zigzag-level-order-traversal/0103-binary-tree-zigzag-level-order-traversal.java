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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        int level = 1;
        if (root == null) return res;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> ar = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i<len;i++){
                TreeNode temp = q.poll();
                ar.add(temp.val);
                if (temp.left != null){
                    q.add(temp.left);
                }
                if (temp.right != null){
                    q.add(temp.right);
                }
            }
            if(level%2 ==0){
                Collections.reverse(ar);
                res.add(ar);
            }else{
                res.add(ar);
            }
            level++;
        }
        return res;
    }
}