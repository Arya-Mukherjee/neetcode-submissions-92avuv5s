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
        if(head == null || head.next == null) return;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next !=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode curr = p1.next;
        ListNode prev = null;
        while(curr !=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode p2head = prev;
        p1.next = null;

        p1 = head;
        p2 = p2head;

        while(p2!=null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;

            p1 = temp1;
            p2= temp2;
        }
    }
}
