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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            if (temp != null) {
                heap.offer(temp);
            }
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode tail = dummy;

        while (!heap.isEmpty()) {
            ListNode min = heap.poll();

            if (min.next != null) {
                heap.offer(min.next);
            }

            tail.next = min;
            tail = tail.next;
        }

        return dummy.next;
    }
}
