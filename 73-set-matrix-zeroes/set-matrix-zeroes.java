class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean colf= false;
        boolean rowf = false;
        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                colf=true;
                break;
            }
        }
        for(int i=0;i<m;i++){
            if(matrix[0][i]==0){
                rowf = true;
                break;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] =0;
                }
            }
        }
        for(int i=1;i<n;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<m;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0;j<m;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<n;i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowf){
            for(int i=0;i<m;i++){
                matrix[0][i]=0;
            }
        }
        if(colf){
            for(int i=0;i<n;i++){
                matrix[i][0] =0;
            }
        }
    }
}