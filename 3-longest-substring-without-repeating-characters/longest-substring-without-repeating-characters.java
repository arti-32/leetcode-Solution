class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int count = 0;
        int ans = 0;
        HashSet<Character> set = new HashSet<>(); 
        while(r<n){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            count=r-l+1;
            ans = Math.max(count,ans);
            r++;
        }
        return ans;
    }
}