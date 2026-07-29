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
    public ListNode reverseList(ListNode left, ListNode rightNext){
        ListNode prev = rightNext;
        ListNode curr = left;
        ListNode after = left.next;
        while(curr != rightNext){
            curr.next = prev;
            prev = curr;
            curr = after;
            if (after != rightNext) after = after.next;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode leftptr = head;
        ListNode rightptr = head;
        ListNode prevLeft = head;
        if(left == 1) prevLeft = dummyNode;
        while(leftptr != null && left != 1){
            prevLeft = leftptr;
            left--;
            leftptr = leftptr.next;
        }
        while (rightptr != null && right != 1){
            right--;
            rightptr = rightptr.next;
        }
        if (leftptr == null || rightptr == null) return head;
        prevLeft.next = reverseList(leftptr,rightptr.next);
        return dummyNode.next;
    }
}