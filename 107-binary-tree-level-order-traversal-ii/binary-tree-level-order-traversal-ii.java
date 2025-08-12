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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        int n = helper(root,0,0,stack);
        List<List<Integer>> ans = new ArrayList<>();
        if(stack.isEmpty()){
            return ans;
        }
        for(int i=0;i<=n;i++){
            ans.add(new ArrayList<>());
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.peek().node;
            int level = stack.peek().level;
            stack.pop();
            ans.get(n-level).add(node.val);
        }
        return ans;
    }
    public int helper(TreeNode root,int level,int mlevel,Stack<Pair> stack){
        if(root==null){

            return mlevel;
        }
        stack.add(new Pair(root,level));
        mlevel = Math.max(level,mlevel);
        return Math.max(helper(root.right,level+1,mlevel,stack),helper(root.left,level+1,mlevel,stack));
    } 
}
class Pair{
    TreeNode node;
    int level;
    public Pair(TreeNode node,int level){
        this.node = node;
        this.level = level;
    }
}