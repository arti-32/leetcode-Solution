class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int prefix = 0;
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i:nums){
            prefix+=i;
            if(map.containsKey(prefix-goal)){
                count+=map.get(prefix-goal);
            }
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        return count;
    }
}