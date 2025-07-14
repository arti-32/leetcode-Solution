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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,new int[]{0},Integer.MAX_VALUE);
    }
    TreeNode helper(int[] preorder,int[] ind,int bound){
        if(ind[0]==preorder.length || preorder[ind[0]]>bound)return null;

        TreeNode node = new TreeNode(preorder[ind[0]++]);
        node.left = helper(preorder,ind,node.val);
        node.right = helper(preorder,ind,bound);
        return node;
    }
}