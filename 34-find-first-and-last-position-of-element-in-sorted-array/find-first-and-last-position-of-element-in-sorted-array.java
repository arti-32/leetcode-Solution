class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] = left(nums,target);
        ans[1] = right(nums,target);
        return ans;
    }
    public int left(int[] nums,int target){
        int start =0;
        int end = nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                ans= mid;
                end = mid-1;
            }
            else if(target<nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    public int right(int[] nums,int target){
        int start =0;
        int end = nums.length-1;
        int ans=-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==target){
                ans= mid;
                start = mid+1;
            }
            else if(target<nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
}