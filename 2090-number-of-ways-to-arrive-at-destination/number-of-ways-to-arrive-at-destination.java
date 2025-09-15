class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();
        int MOD = 1_000_000_007;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] i:roads){
            list.get(i[0]).add(new Pair(i[1],i[2]));
            list.get(i[1]).add(new Pair(i[0],i[2]));
        }
        int[] visit = new int[n];
        visit[0] = 1;
        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->Long.compare(a.weight,b.weight));
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair p =q.poll();
            int node = p.node;
            long weight = p.weight;
            if(dist[node]<weight) continue;
            for(Pair i:list.get(node)){
                long distance = dist[node]+i.weight;
                if(dist[i.node]==distance){
                    visit[i.node]=(visit[node]+visit[i.node])%MOD;
                }
                 else if(dist[i.node]>distance){
                    dist[i.node] = distance;
                    visit[i.node] = visit[node];
                    q.add(new Pair(i.node,dist[i.node]));
                 }
            }
        }
        return visit[n-1]%MOD;
    }
}
class Pair{
    int node;
    long weight;
    public Pair(int node,long weight){
        this.node = node;
        this.weight = weight;
    }
}