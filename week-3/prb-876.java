/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode[] result=new ListNode[100];
        int i=0;
        while (head.next != null) 
        {
            result[i++]=head;
            head=head.next;
        }
        if(i<=1)
            return head;
        if(i%2==0)
            return result[i/2];
        else
            return result[i/2 + 1];
    }
}