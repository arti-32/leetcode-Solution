class Solution {
    public int splitArray(int[] nums, int k) {
        if(k==nums.length){
            int ans=Integer.MIN_VALUE;
            for(int i:nums){
                ans = Math.max(ans,i);
            }
            return ans;
        }
        long start = Long.MAX_VALUE;
        long end = 0;
        long ans=0;
        for(int i:nums){
            end += i;
            start = Math.min(start,i);
        }
        while(start<=end){
            long mid = start+(end-start)/2;
            if(isPossible(nums,k,mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return (int)ans;
    }
    public boolean isPossible(int[] nums,int k,long mid){
        int l = 1;
        long sum = 0;
        for(int i:nums){
            if(i>mid){
                return false;
            }
            else if(i+sum>mid){
                sum=i;
                l+=1;
            }
            else{
                sum+=i;
            }
        }
        return l<=k;
    }
}