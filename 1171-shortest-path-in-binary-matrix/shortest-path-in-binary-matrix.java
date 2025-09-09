class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.val-b.val);
        q.add(new Pair(0,0,1));
        boolean[][] visit = new boolean[n][n];
        visit[0][0] = true;
        int[] drow = {-1,-1,-1,0,1,1,1,0};
        int[] dcol = {-1,0,1,1,1,0,-1,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int val = p.val;
            if(x==n-1 && y==n-1){
                return val;
            }
            for(int i=0;i<8;i++){
                int dx = x+drow[i];
                int dy = y+dcol[i];
                if(dx>=0 && dx<n && dy>=0 && dy<n && grid[dx][dy]==0 && !visit[dx][dy]){
                    q.add(new Pair(dx,dy,val+1));
                    visit[dx][dy] = true;
                }
            }
        }
        return -1;
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