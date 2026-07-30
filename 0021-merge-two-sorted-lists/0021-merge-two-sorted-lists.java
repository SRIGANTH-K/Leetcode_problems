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
        ListNode temp = list1;
        ListNode temp2 = list2;
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        while (temp != null && temp2 != null){
            if(temp.val < temp2.val){
                res.next = temp;
                res = res.next; 
                temp = temp.next;
            }else{
                res.next = temp2;
                res = res.next; 
                temp2 = temp2.next;
            }
        }
        if (temp != null){
            res.next = temp;
        }
        if (temp2 != null){
            res.next = temp2;
        }
        return dummyNode.next;
    }
}