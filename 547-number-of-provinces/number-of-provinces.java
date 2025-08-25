class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        int count = 0;
        boolean[] visit = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                count++;
                dfs(list,visit,i);
            }
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> list,boolean[] visit,int node){
        visit[node] = true;
        for(Integer i:list.get(node)){
            if(!visit[i]){
                dfs(list,visit,i);
            }
        }
    }
}