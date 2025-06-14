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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return helper(root,targetSum,0);
    }
    public boolean helper(TreeNode root,int targetSum,int sum){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            if((root.val+sum)==targetSum){
                return true;
            }
            return false;
        }
        boolean left = helper(root.left,targetSum,sum+root.val);
        boolean right = helper(root.right,targetSum,sum+root.val);
        return left||right;
    }
}