class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int profit=0;
        
        for(int i:prices){
            if(buy<i){
                int ans = i-buy;
                profit = Math.max(ans,profit);
            }
            else{
                buy=i;
            }
        }
        return profit;
    }
}