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
    public ListNode reverseList(ListNode left){
        ListNode prev = null;
        ListNode curr = left;
        ListNode after = left.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = after;
            if(after != null) after = after.next;
        }
        return prev;
    }


    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            prev = slow;
        }
        ListNode midhead=reverseList(slow);
        ListNode temp = head, temp2 = midhead;
        while (temp != null && temp2 != null){
            if(temp.val != temp2.val){
                return false;
            }
            temp=temp.next;
            temp2=temp2.next;
        }
        prev.next = reverseList(slow);
        return true;
    }
}