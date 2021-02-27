/*
In this challenge, you will determine whether a string is funny or not. 
To determine whether a string is funny, create a copy of the string in reverse 
e.g. abc -> cba. Iterating through each string, compare the absolute difference in the ascii 
values of the characters at positions 0 and 1, 1 and 2 and so on to the end. If the list of absolute differences is the same for both strings, they are funny.
Determine whether a give string is funny. If it is, return Funny, otherwise return Not Funny.
*/

// code 

    static String funnyString(String s) {
        String rev = new StringBuffer(s).reverse().toString();
        
        for(int i=0 ; i<s.length()-1 ; i++){
            int one = s.charAt(i);
            int two = s.charAt(i+1);
            int sum = (one > two)? one-two : two-one;
            
            int oneB = rev.charAt(i);
            int twoB = rev.charAt(i+1);
            int sumB = (oneB > twoB)? oneB-twoB : twoB-oneB;
            
            if(sum != sumB) return "Not Funny";
            
        }
        return "Funny";

    }
