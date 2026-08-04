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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.val, b.val));
        for(ListNode node : lists){
            while(node != null){
                pq.add(new ListNode(node.val));
                node = node.next;
            }
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while(!pq.isEmpty()){
            head.next = pq.poll();
            head = head.next;
        }
        return tail.next;
    }
}
