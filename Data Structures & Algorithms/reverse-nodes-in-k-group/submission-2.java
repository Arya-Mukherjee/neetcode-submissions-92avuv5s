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
     public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // check if k nodes exist
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // reverse only if k nodes exist
        if (count == k) {

            // recursively reverse remaining list
            curr = reverseKGroup(curr, k);

            ListNode prev = curr;
            curr = head;

            while (count-- > 0) {

                ListNode next = curr.next;

                curr.next = prev;

                prev = curr;

                curr = next;
            }

            head = prev;
        }

        return head;
    }
}