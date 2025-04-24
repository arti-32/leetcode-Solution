class Solution {
    public boolean isValid(String s) {
        if(s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }
            else if(!stack.isEmpty() && ((ch==')' && stack.peek()=='(') || (ch=='}' && stack.peek()=='{')|| (ch==']' && stack.peek()=='['))){
                stack.pop();
            }
            else{
                return false;
            }
            
        }
        return stack.isEmpty();
    }
}