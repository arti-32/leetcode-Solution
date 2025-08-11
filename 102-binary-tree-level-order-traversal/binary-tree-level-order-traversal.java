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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int m = helper(root,q,0,0);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            ans.add(new ArrayList<>());
        }

        while(!q.isEmpty()){
            TreeNode node = q.peek().node;
            int level = q.peek().level;
            q.poll();
            ans.get(level).add(node.val);
        }
        return ans;

    }
    public int helper(TreeNode root,Queue<Pair> q,int level,int mlevel){
        if(root == null){
            return Math.max(level,mlevel);
        }
        q.add(new Pair(root,level));
        mlevel = Math.max(level,mlevel);
        return Math.max(helper(root.left,q,level+1,mlevel),helper(root.right,q,level+1,mlevel));
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