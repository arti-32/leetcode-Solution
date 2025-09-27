class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k>nums.length){
            return -1;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        for(int i:nums){
            q.add(i);
        }
        int ans = 0;
        for(int i=0;i<k;i++){
            ans = q.poll();
        }
        return ans;
    }
}