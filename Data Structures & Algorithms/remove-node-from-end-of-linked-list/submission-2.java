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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 1 && head.next == null){
            return null;
        }
        int size = 0;
        ListNode curr = head; 
        while(curr != null){
            size++;
            curr = curr.next;
        }
        curr = head;
        n = size - n;
        if(n == 0){
            return head.next;
        }
        ListNode prev = new ListNode();
        curr = head;
        while(n > 0){
            prev = curr;
            curr = curr.next;
            n--;
        }
        prev.next = curr.next;
        return head;
    }
}
