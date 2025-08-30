class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        helper(nums,list,new ArrayList<>(),0);
        return list;
    }
    public void helper(int[] nums,List<List<Integer>> list,List<Integer> curr,int ind){
        if(ind==nums.length){
            if(!list.contains(curr)){
                list.add(new ArrayList<>(curr));
            }
            return;
        }
        curr.add(nums[ind]);
        helper(nums,list,curr,ind+1);
        curr.remove(curr.size()-1);
        helper(nums,list,curr,ind+1);
    }
} 