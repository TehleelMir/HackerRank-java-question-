/*
Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

 

Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]

link : https://leetcode.com/problems/merge-two-sorted-lists/
*/

//code 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int size1 = size(l1);
        int size2 = size(l2);
        if(size1 == 0) return l2;
        else if(size2 == 0) return l1;
        else if( (size1==0) && (size2==0) ) return l1;
        
        ListNode result = new ListNode(-1);
        ListNode sendMe = result;
        ListNode loc = null;
        List<Integer> list = new ArrayList<Integer>();
            
        while( (l1 != null) || (l2 != null) ){
            if( (l1 != null) && (l2 != null) ){
                if(l1.val < l2.val){
                    list.add(l1.val);
                    l1 = l1.next;
                }else{
                    list.add(l2.val);
                    l2 = l2.next;
                }
            }
            if( (l1 != null) && (l2 == null) ){
                list.add(l1.val);
                l1 = l1.next;
            }
            if( (l1 == null) && (l2 != null) ){
                list.add(l2.val);
                l2 = l2.next;
            }
            
        }//brace of while-loop
        for(int i=0 ; i<list.size() ; i++){
            loc = result;
            result.val = list.get(i);
            result.next = new ListNode(0);
            result = result.next;
        }
        loc.next = null;
        return sendMe;
    }
    
    int size(ListNode list){
        int size = 0;
        while(list != null){
            size++;
            list = list.next;
        }
        return size;
    }
}
