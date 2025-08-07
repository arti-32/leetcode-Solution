class Solution {
    public int numEnclaves(int[][] grid) {
        int n= grid.length;
        int m = grid[0].length;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        boolean[][] visit = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(!visit[i][0] && grid[i][0]==1){
                bfs(grid,i,0,drow,dcol,visit);
            }
            if(!visit[i][m-1] && grid[i][m-1]==1){
                bfs(grid,i,m-1,drow,dcol,visit);
            }
        }
        for(int i=0;i<m;i++){
            if(!visit[0][i] && grid[0][i]==1){
                bfs(grid,0,i,drow,dcol,visit);
            }
            if(!visit[n-1][i] && grid[n-1][i]==1){
                bfs(grid,n-1,i,drow,dcol,visit);
            }
        }
        int count = 0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(!visit[i][j] && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int[][] grid,int ro,int co,int[] drow,int[] dcol,boolean[][] visit){
        int n = grid.length;
        int m= grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro,co));
        visit[ro][co] = true;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for(int i=0;i<4;i++){
                int delr = x+drow[i];
                int delc = y+dcol[i];
                if(delr>=0 && delr<n && delc>=0 && delc<m && !visit[delr][delc] && grid[delr][delc]==1){
                    q.add(new Pair(delr,delc));
                    visit[delr][delc] = true;
                }
            }
        }
    }
}
class Pair{
    int x;
    int y;
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}