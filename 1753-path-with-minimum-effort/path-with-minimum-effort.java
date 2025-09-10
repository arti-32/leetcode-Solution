class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.dist-b.dist);
        int[][] distance = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        } 
        distance[0][0] = 0;
        q.add(new Pair(0,0,0));
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int dist = p.dist;
            int x = p.x;
            int y = p.y;

            if(x==n-1 && y==m-1){
                return dist;
            }

            for(int i=0;i<4;i++){
                int dr = x+drow[i];
                int dc = y+dcol[i];
                if(dr>=0 && dr<n && dc>=0 && dc<m){
                    int val = Math.max(dist,Math.abs(heights[x][y]-heights[dr][dc]));
                    if(val<distance[dr][dc]){
                        distance[dr][dc] = val;
                        q.add(new Pair(val,dr,dc));
                    }
                }
            }
        }
        return 0;
    }
}
class Pair{
    int dist;
    int x;
    int y;
    public Pair(int dist,int x,int y){
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}