class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n =isConnected.length;
        boolean[] visit= new boolean[n];
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
        int ans =0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                ans++;
                dfs(list,visit,i);
            }
        }
        return ans;
    }
    private void dfs(ArrayList<ArrayList<Integer>> list,boolean[] visit,int node){
        visit[node]= true;
        for(Integer i:list.get(node)){
            if(!visit[i]){
                dfs(list,visit,i);
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