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
        ListNode dummy = new ListNode(9999);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // step 1: find middle of list to break into 2 lists
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // detach the 2 lists
        ListNode list1 = head;
        ListNode list2 = slow.next;
        slow.next = null;

        //step 2: reverse list2
        ListNode prev = null;
        ListNode curr = list2;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        list2 = prev;

        while(list1 != null & list2 != null){
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;

            list1.next = list2;
            list2.next = temp1;

            list1 = temp1;
            list2 = temp2;
        }

    }
}
