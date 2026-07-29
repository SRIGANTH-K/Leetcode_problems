/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*ListNode fast = head;
        ListNode slow = head;
        ListNode start = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                
                while (fast != start){
                    
                    fast.next = fast.next;
                    start.next = start.next;
                    
                }
                return fast;
            }  
                
            
        }
        return null;*/


        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                slow = head;
                while (fast != slow){
                    
                    fast = fast.next;
                    slow = slow.next;
                    
                }
                return fast;
            }
        }
        return null;
    }
}