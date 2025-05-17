class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0){
            return 0;
        }
        // if(citations.length==1 && citations[0]>0){
        //     return 1;
        // }
        int ans=0;
        int start=0;
        int end = citations[citations.length-1];
        while(start<=end){
            int mid= start+(end-start)/2;
            if(isPossible(citations,mid)){
                start = mid+1;
                ans=mid;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] citations,int mid){
        int first = helper(citations,mid);
        if((citations.length-first)>=mid){
            return true;
        }
        else{
            return false;
        }
    }
    public int helper(int[] arr,int num){
        int start=0;
        int end = arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            // if(arr[mid]==num){
            //     return mid;
            // }
            if(arr[mid]<num){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return start;
    }
}