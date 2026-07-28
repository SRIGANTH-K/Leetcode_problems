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
        if (head.next == null && n==1) return null;
        ListNode i = head, j = head, prev = head;
        int l = 1;
        while (l<n){
            j = j.next;
            if (j==null) return head;
            l++;
        }
        if (j.next==null) return head.next;
        while(j.next != null){
            j = j.next;
            prev = i;
            i=i.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}