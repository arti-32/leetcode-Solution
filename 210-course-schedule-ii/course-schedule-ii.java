class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(!canFinish(numCourses,prerequisites)){
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visit = new boolean[numCourses];
        int[] ans = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<numCourses;i++){
            if(!visit[i]){
                dfs(numCourses,adj,visit,stack,i);
            }
        }
        int i=0;
        while(!stack.isEmpty()){
            ans[i++]= stack.pop();
        }
        return ans;
    }
    private void dfs(int numCourses,ArrayList<ArrayList<Integer>> adj,boolean[] visit,Stack<Integer> stack,int node){
        visit[node] = true;
        for(Integer i:adj.get(node)){
            if(!visit[i]){
                dfs(numCourses,adj,visit,stack,i);
            }
        }
        stack.add(node);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for(int[] i:prerequisites){
            inDegree[i[0]]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int p = q.poll();
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1]==p){
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]]==0){
                        q.add(prerequisites[i][0]);
                    }
                }
            }
            list.add(p);
        }
        return list.size()==numCourses;
    }
}