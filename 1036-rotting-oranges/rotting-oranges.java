class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visit[i][j] = true;
                }
            }
        }
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int val = q.peek().val;
            ans = Math.max(ans,val);
            q.poll();
            for(int i=0;i<4;i++){
                int delr = x+dr[i];
                int delc = y+dc[i];
                if(delr>=0 && delr<n && delc>=0 && delc<m && !visit[delr][delc] && grid[delr][delc]==1){
                    grid[delr][delc] = 2;
                    q.add(new Pair(delr,delc,val+1));
                    visit[delr][delc] = true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==1){
                    return -1;
                }
            }
        }
        return ans;
    }
}
class Pair{
    int x;
    int y;
    int val;
    public Pair(int x,int y,int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}