class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    visit[i][j] = true;
                }
            }
        }
        int[] drow = {-1,0,1,0};
        int[] dcol= {0,1,0,-1};
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int val = q.peek().ind;
            q.poll();
            
            for(int i=0;i<4;i++){
                int delr = x+drow[i];
                int delc = y+dcol[i];
                if(delr>=0 && delr<n && delc>=0 && delc<m && mat[delr][delc]==1 && !visit[delr][delc]){
                    ans[delr][delc] = val+1;
                    q.add(new Pair(delr,delc,val+1));
                    visit[delr][delc] = true;
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