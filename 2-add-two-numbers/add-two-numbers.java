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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode((l1.val+l2.val)%10);
        ListNode ans1 = ans;
        int carry=0;
        if((l1.val+l2.val)>=10){
            carry = 1;
        }
        l1 = l1.next;
        l2 = l2.next;
        while(l1!=null || l2!=null || carry!=0){
            int sum = carry;
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            ListNode ad = new ListNode(sum%10);
            ans.next = ad;
            ans = ans.next;
            if(sum>=10){
                carry = 1;
            }
            else{
                carry=0;
            }
        }
        return ans1;
    }
}