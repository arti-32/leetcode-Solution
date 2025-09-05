class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        for(int i=0;i<wordList.size();i++){
            st.add(wordList.get(i));
        }
        while(!q.isEmpty()){
            int val = q.peek().val;
            String str = q.peek().str;
            q.poll();
            if(str.equals(endWord)) return val;

            for(int i=0;i<str.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr = str.toCharArray();
                    arr[i] = ch;
                    String newStr = new String(arr);
                    if(st.contains(newStr)){
                        q.add(new Pair(newStr,val+1));
                        st.remove(newStr);
                    }
                }
            }
        }
        return 0;
    }
}
class Pair{
    String str;
    int val;
    public Pair(String str,int val){
        this.str = str;
        this.val = val;
    }
}