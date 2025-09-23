class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int ans =0;
        for(int j=0;j<nums.length;j++){
            // if(nums[j]==1){
            //     ans = Math.max(ans,j-i+1);
            //     continue;
            // }
            if(nums[j]==0){
                if(k>0){
                    k--;
                }
                else if(k==0){
                    while(nums[i]==1){
                        i++;
                    }
                    i++;
                }
            }
            ans = Math.max(ans,j-i+1);

        }
        return ans;
    }
}