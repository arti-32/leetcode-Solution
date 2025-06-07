class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int[] nums,int ind,List<Integer> list,List<List<Integer>> ans){
        if(ind==nums.length){
            if(!ans.contains(list)){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        helper(nums,ind+1,list,ans);
        list.add(nums[ind]);
        helper(nums,ind+1,list,ans);
        list.remove(list.size()-1);
    }
    
}