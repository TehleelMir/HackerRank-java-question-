/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

link : https://leetcode.com/problems/add-two-numbers/ 
*/

//code 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        toList(list1 , l1);
        toList(list2 , l2);
        list1 = reverse(list1);
        list2 = reverse(list2);
        String resultSum = "";
        int size = Math.max(list1.size() , list2.size());
        int carri = 0;
        
        
        for(int i=list1.size()-1 , j=list2.size()-1 , y=0 ; y<size ; y++ , i-- , j--){
            int sum = 0;
            if(j>=0 && i>=0){
                sum = list1.get(i) + list2.get(j) + carri;
                if(sum >= 10){
                    int temp = sum%10;
                    carri = sum/10;
                    sum = temp;
                }else carri = 0;
            }
            if(j>=0 && !(i>=0)){
                sum += list2.get(j) + carri;
                if(sum >= 10){
                    int temp = sum%10;
                    carri = sum/10;
                    sum = temp;
                }else carri = 0;
            }
            if(!(j>=0) && i>=0){
                sum += list1.get(i) + carri;
                if(sum >= 10){
                    int temp = sum%10;
                    carri = sum/10;
                    sum = temp;
                }else carri = 0;
            }
            
            resultSum += sum+"";
        }
        if(carri != 0) resultSum+= carri+"";
        
        ListNode list = new ListNode(0);
        ListNode result = list;
        ListNode loc = null;
        
        for(int i=0 ; i<resultSum.length() ; i++){
            try{
                int number = Integer.parseInt(resultSum.charAt(i)+"");
                
                loc = list;
                list.val = number;
                list.next = new ListNode(0);
                list = list.next;
            }catch(Exception e){}
        }
        loc.next = null;
        return result;
     
    }
    
    void toList(ArrayList<Integer> list , ListNode l){
        while(l != null){
            list.add(l.val);
            l = l.next;
        }
    }
    
    ArrayList<Integer> reverse(ArrayList<Integer> list){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=list.size()-1 ; i>=0 ; i--){
            result.add(list.get(i));
        }
        return result;
    }
}
