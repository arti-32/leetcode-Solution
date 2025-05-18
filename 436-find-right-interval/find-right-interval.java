class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] ans = new int[n];
        int[][] ind = new int[n][2];
        for(int i=0;i<n;i++){
            ind[i][0] = intervals[i][0];
            ind[i][1] = i;
        }
        Arrays.sort(ind,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            int place = poss(ind,intervals[i][1]);
            ans[i] = place;
        }
        return ans;
    }
    public int poss(int[][] ind,int target){
        int in=-1;
        int start = 0;
        int end = ind.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(ind[mid][0]>=target){
                in = mid;
                end= mid-1;;
            }
            else{
                start=mid+1;
            }
        }
        return in==-1?-1:ind[in][1];
    }
}