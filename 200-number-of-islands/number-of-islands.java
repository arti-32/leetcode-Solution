class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visit = new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visit[i][j]==0 && grid[i][j]=='1'){
                    count++;
                dfs(grid,visit,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int[][] visit,int ro,int co){
        visit[ro][co] = 1;
        int n= visit.length;
        int m = visit[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro,co));
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int i = q.peek().first;
            int j = q.peek().second;
            q.remove();


            for(int p=0;p<4;p++){
                int delrow = i+drow[p];
                int delcol = j+dcol[p];
                if(delrow>=0 && delrow<n && delcol>=0 && delcol<m && grid[delrow][delcol]=='1' && visit[delrow][delcol]==0){
                    visit[delrow][delcol] = 1;
                    q.add(new Pair(delrow,delcol));
                }
            }
        }

    }
}
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}