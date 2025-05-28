class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[k++] = nums1[i++];
            }
            else{
                arr[k++] = nums2[j++];
            }
        }
        while(i<nums1.length){
            arr[k++] = nums1[i++];
        }
        while(j<nums2.length){
            arr[k++] = nums2[j++];
        }
        if(arr.length%2!=0){
            return (double)arr[arr.length/2];
        }
        int n = arr.length;
        return (double)(arr[n/2-1]+arr[n/2])/2;
    }
}