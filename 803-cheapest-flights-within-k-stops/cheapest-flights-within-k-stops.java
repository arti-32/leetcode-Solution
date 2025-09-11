class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Peer>> list = new ArrayList<>();
        int[] distance = new int[n];
        for(int i=0;i<n;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] p:flights){
            list.get(p[0]).add(new Peer(p[1],p[2]));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0,0));
        distance[src] = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int dist = p.dist;
            int ind = p.ind;


            if(ind>=k+1){
                continue;
            }

            for(Peer i:list.get(node)){
                if(ind<=k && distance[i.node]>i.weight+dist){
                    distance[i.node]= i.weight+dist;
                    q.add(new Pair(i.node,i.weight+dist,ind+1));
                }
            }
        }
        if(distance[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return distance[dst];
    }
}
class Peer{
    int node;
    int weight;
    public Peer(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
}
class Pair{
    int node;
    int dist;
    int ind;
    public Pair(int node,int dist,int ind){
        this.node = node;
        this.dist = dist;
        this.ind = ind;
    }
}