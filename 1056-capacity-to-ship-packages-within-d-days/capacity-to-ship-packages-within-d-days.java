class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long end = 0;
        long start = 0;
        long ans=1;
        for(int i:weights){
            end+=i;
            start = Math.max(start,i);
        }
        while(start<=end){
            long mid = start+(end-start)/2;
            if(isPossible(weights,days,mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return (int)ans;
    }
    public boolean isPossible(int[] weights,int days,long mid){
        int poss = 1;
        long load = 0;
        for(int i:weights){
            if((i+load)>mid){
                load = i;
                poss+=1;
            }
            else{
                load+=i;
            }
        }
        return days>=poss;
    }
}   