class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q= new LinkedList<>();
        int n = grid.length;
        int m=grid[0].length;
        int freshCount = 0;
        int[][] visit = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visit[i][j] = 2;
                }
                else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        
        int t = 0;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int count=0;
        while(!q.isEmpty()){
            int row = q.peek().ro;
            int col = q.peek().co;
            int tm = q.peek().tm; 
            t = Math.max(t,tm);
            q.remove();
            for(int i=0;i<4;i++){
                int delr = row+drow[i];
                int delc = col+dcol[i];
                if(delr>=0 && delr<n && delc>=0 && delc<m && visit[delr][delc]!=2 && grid[delr][delc]==1){
                    q.add(new Pair(delr,delc,tm+1));
                    visit[delr][delc] = 2;
                    count++;
                }
            }

        }
        if(freshCount!=count++){
            return -1;
        }
        return t;
    }
}
class Pair{
    int ro;
    int co;
    int tm;
    public Pair(int ro,int co,int tm){
        this.ro=ro;
        this.co = co;
        this.tm = tm;
    }
}