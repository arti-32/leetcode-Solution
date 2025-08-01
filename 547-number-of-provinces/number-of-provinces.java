class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        boolean[] visit = new boolean[n];
        int count=0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!visit[i]){
                count++;
                dfs(isConnected,visit,i,adj);
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected,boolean[] visit,int node,ArrayList<ArrayList<Integer>> adj){
        visit[node] = true;
        for(Integer i:adj.get(node)){
            if(!visit[i]){
                dfs(isConnected,visit,i,adj);
            }
        }
    }
}