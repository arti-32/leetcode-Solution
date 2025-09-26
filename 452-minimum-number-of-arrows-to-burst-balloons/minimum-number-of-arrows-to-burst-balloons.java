class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        int n = points.length;
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int ans = 1;
        int curr = points[0][1];
        for(int i=1;i<n;i++){
            if(points[i][0]>curr){
                curr = points[i][1];
                ans++;
            }
        }
        return ans;
    }
}