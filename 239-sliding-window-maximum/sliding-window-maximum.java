import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int p=0;
        // if(k>=n){
        //     return ;
        // }
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxa = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            maxa = Math.max(maxa,nums[i]);
        }
        ans[p++] = maxa;
        for(int i=k;i<n;i++){
            map.put(nums[i-k],map.get(nums[i-k])-1);
            if(map.get(nums[i-k])==0) map.remove(nums[i-k]);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.containsKey(maxa)){
                maxa = Math.max(maxa,nums[i]);
            }
            else{
                maxa = Integer.MIN_VALUE;
                for(int j=i-k+1;j<=i;j++){
                    maxa = Math.max(maxa,nums[j]);
                }
            }
            ans[p++] = maxa;
        }
        return ans;
    }
}
