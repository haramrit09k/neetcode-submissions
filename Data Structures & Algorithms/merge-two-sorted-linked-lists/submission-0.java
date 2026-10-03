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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = null;

        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        

        // initialize new head based on min value between both lists
        if(list1.val < list2.val){
            newHead = list1;
            list1 = list1.next; // remember to move pointer forward after every operation appropriately
        }
        else{
            newHead = list2;
            list2 = list2.next;
        }

        ListNode curr = newHead;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                curr = l1;
                l1 = l1.next;
            }
            else if(l2.val < l1.val){
                curr.next = l2;
                curr = l2;
                l2 = l2.next;
            }
        }

        while(l1 != null){
            curr.next = l1;
            curr = l1;
            l1 = l1.next;
        }

        while(l2 != null){
            curr.next = l2;
            curr = l2;
            l2 = l2.next;
        }

        return newHead;

    }
}