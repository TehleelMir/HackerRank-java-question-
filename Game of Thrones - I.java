/*
Dothraki are planning an attack to usurp King Robert's throne.
King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.

But, to lock the door he needs a key that is an anagram of a palindrome.
He starts to go through his box of strings, checking to see if they can be rearranged 
into a palindrome. Given a string, determine if it can be rearranged into a palindrome. Return the string YES or NO.
*/

//code 

    static String gameOfThrones(String s) {
        String[] temp = s.split("");
        Arrays.sort(temp);
        boolean hold = true;
        int count = 1;
        for(int i=0 ; i<temp.length-1 ; i++){
            if(temp[i].equals(temp[i+1]) ){
                count++;
            }else{
                if(count == 1 && hold){
                        hold = false;
                        count = 1;
                }
                else if(count%2 == 0){
                    count = 1;
                }
                else if(count%2 != 0 && hold){
                    hold = false;
                    count = 1;
                }
                else{
                    return "NO";
                }
            }
        }
    return "YES";
    }
