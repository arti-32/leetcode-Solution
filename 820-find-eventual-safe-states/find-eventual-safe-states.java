class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visit = new boolean[n];
        boolean[] path = new boolean[n];
        boolean[] ans = new boolean[n];
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<graph.length;i++){
            if(!visit[i]){
                dfs(graph,visit,path,ans,i);
            }
        }
        for(int i=0;i<ans.length;i++){
            if(ans[i]){
                list.add(i);
            }
        }
        return list;
    }
    public boolean dfs(int[][] graph,boolean[] visit,boolean[] path,boolean[] ans,int node){
        visit[node] = true;
        path[node] = true;
        for(Integer i:graph[node]){
            if(!visit[i]){
                if(dfs(graph,visit,path,ans,i))return true;
            }
            else if(path[i]){
                return true;
            }
        }
        path[node] = false;
        ans[node] = true;
        return false;
    } 
}