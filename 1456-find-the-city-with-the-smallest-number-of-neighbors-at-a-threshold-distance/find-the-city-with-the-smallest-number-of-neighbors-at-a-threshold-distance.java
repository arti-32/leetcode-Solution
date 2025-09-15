class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int ans = Integer.MAX_VALUE;
        int val = 0;
        int[] city = new int[n];
        int[][] mat = new int[n][n];
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] i:edges){
            mat[i[0]][i[1]] = i[2];
            mat[i[1]][i[0]] = i[2];
        }

       
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j){
                        mat[i][j] =0;
                    }
                    if(mat[i][k]!=Integer.MAX_VALUE && mat[k][j]!=Integer.MAX_VALUE){
                        mat[i][j] = Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]<=distanceThreshold && mat[i][j]!=0){
                    city[i]++;
                    city[j]++;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(city[i]<=ans ){
                ans = city[i];
                val = i;
            }
        }
        return val;
    }
}
class Pair{
    int node;
    int weight;
    public Pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
}