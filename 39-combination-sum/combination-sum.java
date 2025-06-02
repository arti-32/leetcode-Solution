class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates,target,0,new ArrayList<>(),ans);   
        return ans; 
    }
    public void helper(int[] candidates,int target,int ind,ArrayList<Integer> list,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || ind==candidates.length){
            return;
        }
        list.add(candidates[ind]);
        helper(candidates,target-candidates[ind],ind,list,ans);
        list.remove(list.size()-1);
        helper(candidates,target,ind+1,list,ans);
    }
} 