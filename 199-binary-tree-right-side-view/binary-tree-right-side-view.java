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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root,1,list);
        return list;
    }















    int ml = 0;
    public void helper(TreeNode root,int l,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        if(ml<l){
            list.add(root.val);
            ml = l;
        }
        helper(root.right,l+1,list);
        helper(root.left,l+1,list);
    }











    // int ml = 0;
    // public void helper(TreeNode root,int cl,ArrayList<Integer> list){
    //     if(root==null){
    //         return;
    //     }
    //     if(ml<cl){
    //         list.add(root.val);
    //         ml = cl;
    //     }
    //     helper(root.right,cl+1,list);
    //     helper(root.left,cl+1,list);
    // }
}