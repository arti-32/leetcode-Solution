class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j] && grid[i][j]=='1'){
                    ans++;
                    dfs(grid,visit,i,j);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid,boolean[][] visit,int x,int y){
        visit[x][y] = true;
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int delr = x+drow[i];
            int delc = y+dcol[i];
            if(delr>=0 && delr<grid.length && delc>=0 && delc<grid[0].length && !visit[delr][delc] && grid[delr][delc]=='1'){
                dfs(grid,visit,delr,delc);
            }
        }

    }
}