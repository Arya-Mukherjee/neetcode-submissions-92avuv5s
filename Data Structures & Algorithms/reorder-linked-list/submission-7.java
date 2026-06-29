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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return; //check if existing
        ListNode p1 = head; //star
        ListNode p2 = head; //start
        while(p2.next != null && p2.next.next !=null){ //traverse till end tortoise method and find middle
            p1 = p1.next;  //points to middle at the end of loop
            p2 = p2.next.next;
        }
        ListNode curr = p1.next; //p1 is at the middle and we will reverse from next
        ListNode prev = null; //at first previous is null
        while(curr !=null){
            ListNode next = curr.next;  //stores the next node
            curr.next = prev; //links to previous node
            prev = curr; //current element moves to previous node
            curr = next; //the next element of current moves to the current node pointer
        }
        ListNode p2head = prev;  //at the end of reversal prev points to the start of reverse list
        p1.next = null;  //points to end of p1 list as it will be last node of the list always/

        p1 = head; //start of the list
        p2 = p2head;  //start from the middle of the list

        while(p2!=null){
            ListNode temp1 = p1.next; //stores the next of p1 temporarily
            ListNode temp2 = p2.next; //stores the next of p2 temporarily
            p1.next = p2;    //link between first list and reversed list
            p2.next = temp1;  //link between ORIGINAL next of p1 to the next of p2 after being joined to p1

            p1 = temp1; //moves forward
            p2= temp2; //moves forward
        }
    }
}
