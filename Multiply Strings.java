/*

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

link : https://leetcode.com/problems/multiply-strings/

*/

//code 

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        return mul(num1 , num2);
    }
    
    // this method converts char into int
    int parseInt(char c){
        if(c == 48) return 0;
        return (c % 49) + 1;
    }
    
    // this function add's two number which are in string using carri ( like real)
    String sumTwoNumber(String one , String two){
        int size = Math.max(one.length() , two.length());
        int carri = 0;
        String resultSum = "";
        
        for(int i=one.length()-1,j=two.length()-1,y=0 ; y<size ; y++,i--,j--){
            int sum = 0;
            if(j>=0 && i>=0){
                sum = parseInt(one.charAt(i)) + parseInt(two.charAt(j)) + carri;
                if(sum >= 10){
                    int temp = sum%10;
                    carri = sum/10;
                    sum = temp;
                }else carri = 0;
            }
            if(j>=0 && !(i>=0)){
                sum += parseInt(two.charAt(j)) + carri;
                if(sum >= 10){
                    int temp = sum%10;
                    carri = sum/10;
                    sum = temp;
                }else carri = 0;
            }
            if(!(j>=0) && i>=0){
                sum += parseInt(one.charAt(i)) + carri;
                if(sum >= 10){
                    int temp = sum%10;
                    carri = sum/10;
                    sum = temp;
                }else carri = 0;
            }
            
            resultSum += sum+"";
        }//brace of for loop
        if(carri != 0) resultSum+= carri+"";
        
        return ( new StringBuffer(resultSum) ).reverse().toString(); 
    }
    
    // this method multiplys two string in traditional way 
    String mul(String one , String two){
        int carri = 0;
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=one.length()-1 , count=0 ; i>=0 ; i-- , count++){
            int sum = 0;
            String hold = "";
            for(int j=two.length()-1 ; j>=0 ; j--){
                sum = parseInt(one.charAt(i)) * parseInt(two.charAt(j)) + carri;
                    if(sum >= 10){
                    int temp = sum%10;
                    carri = sum/10;
                    sum = temp;
                }else carri = 0;
                
                hold += sum+"";
            }//brace of inner loop
            if(carri != 0) hold+= carri+"";
            carri = 0;
            for(int k=1 ; k<=count ; k++){
                hold = "0" + hold; 
            }
            list.add(new StringBuffer(hold).reverse().toString());
        }//brace of outer loop
        
        if(list.size() == 1) return list.get(0);
        String temp = list.get(0);
        for(int i=1 ; i<list.size() ; i++)
            temp = sumTwoNumber(temp , list.get(i));
        return temp;
    }
}
