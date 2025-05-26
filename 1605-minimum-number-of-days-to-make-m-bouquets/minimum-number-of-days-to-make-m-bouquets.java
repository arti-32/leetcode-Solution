class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k>n){
            return -1;
        }
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i:bloomDay){
            mini = Math.min(mini,i);
            maxi = Math.max(maxi,i);
        }
        int ans = -1;
        while(mini<=maxi){
            int mid = mini+(maxi-mini)/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans = mid;
                maxi = mid-1;
            }
            else{
                mini = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] bloomDay,int mid,int m,int k){
        int poss=0;
        int bouquets =0;
        for(int i:bloomDay){
            if(i<=mid){
                poss++;
            }
            else{
                bouquets+=(poss/k);
                poss=0;
            }
        }
        bouquets+=(poss/k);
        return bouquets>=m;
    }
}