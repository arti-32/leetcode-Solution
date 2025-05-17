class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans ={-1,-1};
        ans[0] = bSearch(nums,target,true);
        ans[1] = bSearch(nums,target,false);
        return ans;
    }
    public int bSearch(int[] nums,int target,boolean isFirst){
        int ans=-1;
        int start=0;
        int end = nums.length-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(nums[mid]==target){
                ans=mid;
                if(isFirst){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else if(target>nums[mid]){
                start= mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
}