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
    public ListNode reverseList(ListNode head) {
        // Gotcha 1: If head is null, return null immediately (empty list case)
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // Gotcha 2: Store `curr.next` before modifying `curr`, or you'll lose access to the rest of the list
            ListNode temp = curr.next;

            // Gotcha 3: Reverse the pointer direction before moving forward
            curr.next = prev;

            // Move prev and curr forward
            prev = curr;
            curr = temp;
        }

        // Gotcha 4: The new head is `prev`, not `head`
        return prev;
    }
}
