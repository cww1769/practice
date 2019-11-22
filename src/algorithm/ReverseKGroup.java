package algorithm;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) 
            return head;
        int i = 0;
        ListNode p = head;
        while (p != null && i < k){
            i++;
            p = p.next;
        }
        if (i < k) 
           return head;
        //from head -> p, reverse linkedlist
        ListNode pre = reverseKGroup(p, k);
		ListNode next =null;
		while (head != p) {
			next = head.next;
		    head.next = pre;
		    pre = head;
		    head = next;
		}
		return pre;
    }
}
