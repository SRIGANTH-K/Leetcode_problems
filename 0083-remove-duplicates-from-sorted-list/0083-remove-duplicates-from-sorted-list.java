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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        
        if (head == null) return null;
        while (curr.next != null){
            if (curr.val == curr.next.val){
                curr.next = curr.next.next;
            }
            else curr = curr.next;
            //f (temp.data != temp.next.data) temp = temp.next;
        }
        return head;
    }
}