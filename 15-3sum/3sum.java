class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n= nums.length;
        List<List<Integer>> ll = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = n-1;
            //int sum = nums[i] +nums[j]+nums[k];
            while(j<k){
                int sum = nums[i] +nums[j]+nums[k];
            if(sum>0){
                k--;
            }
            else if(sum<0) {
                     j++;
            }
            else{
              ll.add(Arrays.asList(nums[i],nums[j],nums[k]));
              while(j<k &&nums[k-1]==nums[k]){
                k--;
              }  
              while(j<k &&nums[j]==nums[j+1]){
                j++;
              }  
              j++;
              k--;
             }
        }
        }
        return ll;
    }
}