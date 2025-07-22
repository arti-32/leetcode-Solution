class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1;
        int n= nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            rev(0,n-1,nums);
            return;
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]>nums[ind]){
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }
        rev(ind+1,n-1,nums);

    }
    public void rev(int start,int end,int[] arr){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
}