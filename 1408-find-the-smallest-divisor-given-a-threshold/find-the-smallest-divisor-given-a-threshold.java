class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int ans = 0;
        int start=1;
        int end = Integer.MIN_VALUE;
        for(int i:nums){
            end = Math.max(end,i);
        }
        while(start<=end){
            int mid = start+(end-start)/2;
            if(isPossible(nums,mid,threshold)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] nums,int mid,int threshold){
        int poss=0;
        for(int i:nums){
            poss+=Math.ceil((float)i/mid);
        }
        return poss<=threshold;
    }
}