/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
*/

//code 

class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> list = new ArrayDeque<>();
        
        for(char x : s.toCharArray()){
            if(x == '('){
                list.add(x);
            }
            if(x == '['){
                list.add(x);  
            }
            if(x == '{'){
                list.add(x);
            }
            
            try{
            if(x == ')'){
                if(list.removeLast() != '(') return false; 
            }
            if(x == ']'){
                if(list.removeLast() != '[') return false;
            }
            if(x == '}'){
                if(list.removeLast() != '{') return false;
            }
        }catch(Exception e){
            return false;
        }
        
        }
        if(list.isEmpty())
        return true;
        return false;
    }
}
