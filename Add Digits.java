/*
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.
             */
             
 //link: https://leetcode.com/problems/add-digits/ 
 
 //code 
 
 class Solution {
    int hold = 0;
    public int addDigits(int num) {
        
        int sum = 0;
        int length = (num+"").length();
        for(int i=0 ; i<length ; i++){
            sum += num%10;
            num /= 10;
        }
        
        if(sum >= 10){
            addDigits(sum);
        }
        else{
            hold = sum;
        }
        return hold;
    }
}
