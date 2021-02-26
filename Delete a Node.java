/*
Delete the node at a given position in a linked list and return a 
reference to the head node. The head is at position 0. 
The list may be empty after you delete the node. In that case, return a null value.
*/

//code 

    // Complete the deleteNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if(position == 0){
            if(head.next != null){
                head = head.next;
                return head;
            }else{
                return null;
            }    
        }
        
        SinglyLinkedListNode temp = head;
        SinglyLinkedListNode temp1;
        int count = -1;
        while(head != null){
            count++;
            if(count == position-1){
                temp1 = head.next;
                if(temp1.next != null){
                    head.next = temp1.next;
                }else{
                    head.next = null;
                }
                return temp;
            }
            head = head.next;
        }
        return temp;
    }
