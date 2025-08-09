class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[graph.length];
        for(int i=0;i<color.length;i++){
            color[i] = -1;
        }
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                if(!bfs(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph,int start,int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] =0;
        while(!q.isEmpty()){
            int p = q.peek();
            q.poll();
            for(int i:graph[p]){
                if(color[i]==-1){
                    q.add(i);
                    color[i] = 1-color[p];
                }
                else if(color[i]==color[p]){
                    return false;
                }
            }
        }
        return true;
    }
}