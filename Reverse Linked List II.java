/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
*/

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right ) return head;
        
        ListNode temp = head;
        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();
        
        while(temp!=null){
            count++;
            if(count >= left && count <= right){
                list.add(temp.val);
            }
            temp = temp.next;
        }
        
        temp = head;
        count = 0;
 
        while(temp!=null){
            count++;
            if(count >= left && count <= right){
                temp.val = list.removeLast();
            }
            temp = temp.next;
        }
        
        return head;
            
    }
}
