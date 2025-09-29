class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            if(target>=matrix[i][0] && target<=matrix[i][m-1]){
                return bSearch(matrix[i],target);
            }
        }
        return false;
    }
    public boolean bSearch(int[] arr,int target){
        int st =0;
        int end = arr.length-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(target>arr[mid]){
                st = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return false;
    }
}