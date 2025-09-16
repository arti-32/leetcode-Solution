class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] i:times){
            list.get(i[0]).add(new Pair(i[1],i[2]));
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.weight-b.weight);
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = Integer.MIN_VALUE;
        dist[k] = 0;
        q.add(new Pair(k,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node=  p.node;
            int weight = p.weight;

            for(Pair i:list.get(node)){
                if(dist[i.node]>dist[node]+i.weight){
                    dist[i.node] = dist[node]+i.weight;
                    q.add(new Pair(i.node,dist[i.node]));
                }
            }
        }
        for(int i=0;i<n+1;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i] =-1;
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n+1;i++){
            if(dist[i]==-1) return -1;
            if(i!=k && ans<dist[i]){
                ans = dist[i];
            }
        }

        return ans;
    }
}
class Pair{
    int node;
    int weight;
    public Pair(int node,int weight){
        this.node=node;
        this.weight = weight;
    }
}