class Solution {
    int i=0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String temp="";
        int count=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch=='['){
                i++;
                temp=decodeString(s);
                int j =0;
                while(j<count){
                    sb.append(temp);
                    j++;
                }
                count=0;

            }
            else if(Character.isAlphabetic(ch)){
                sb.append(ch);
                i++;
            }
            else if(ch==']'){
                i++;
                break;
            }
            else{
                count=count*10+ch-'0';
                i++;
            }
        }
        return sb.toString();
    }
}