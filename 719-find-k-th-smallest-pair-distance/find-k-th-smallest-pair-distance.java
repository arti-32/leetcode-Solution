class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[n-1];
        while(left<=right){
            int mid = left+(right-left)/2;
            int count = findCount(nums,mid);
            if(count>=k){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    public int findCount(int[] nums,int mid){
        int count =0;
        int j= 0;
        for(int i=1;i<nums.length;i++){
            while(nums[i]-nums[j]>mid){
                j++;
            }
            count+=(i-j);
        }
        return count;
    }
}
