class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visit = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j] && grid[i][j]=='1'){
                    count++;
                    visit[i][j] = true;
                    q.add(new Pair(i,j));
                    bfs(grid,visit,q);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,boolean[][] visit,Queue<Pair> q){
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();
            for(int i=0;i<4;i++){
                int delr = x+drow[i];
                int delc = y+dcol[i];
                if(delr>=0 && delr<grid.length && delc>=0 && delc<grid[0].length && !visit[delr][delc] && grid[delr][delc]=='1'){
                    visit[delr][delc] = true;
                    q.add(new Pair(delr,delc));
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