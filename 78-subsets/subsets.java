class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(nums,0,list,new ArrayList<>());
        return list;
    }
    public void helper(int[] nums,int ind,List<List<Integer>> list,List<Integer> curr){
        if(ind==nums.length){
            list.add(new ArrayList<>(curr));
            return;
        }
        helper(nums,ind+1,list,curr);
        curr.add(nums[ind]); 
        helper(nums,ind+1,list,curr);
        curr.remove(curr.size()-1);
    }
}