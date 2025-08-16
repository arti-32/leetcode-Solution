class Solution {
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
