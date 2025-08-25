class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visit = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int[][] ans = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] ==0){
                    visit[i][j] = true;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int[] delr ={-1,0,1,0};
        int[] delc = {0,1,0,-1};
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int ind = q.peek().ind;
            q.poll();

            for(int i=0;i<4;i++){
                int drow = x+delr[i];
                int dcol = y+delc[i];
                if(drow>=0 && drow<n && dcol>=0 && dcol<m && !visit[drow][dcol] && mat[drow][dcol]==1){
                    visit[drow][dcol] = true;
                    ans[drow][dcol] = ind+1;
                    q.add(new Pair(drow,dcol,ind+1));
                }
            }
        }
        return ans;
    }
}
class Pair{
    int x;
    int y;
    int ind;
    public Pair(int x,int y,int ind){
        this.x = x;
        this.y = y;
        this.ind = ind;
    }
}