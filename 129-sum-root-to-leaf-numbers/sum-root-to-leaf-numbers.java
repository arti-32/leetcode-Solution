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
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode root,int curr){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return curr*10+root.val;
        }
        return helper(root.left,curr*10+root.val)+helper(root.right,curr*10+root.val);
    }
}