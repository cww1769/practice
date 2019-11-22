package algorithm;

public class ReverseLinkedList {

	public static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode pre = null;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;

	}

	public static ListNode gReverse(ListNode head, ListNode a, ListNode b) {
		System.out.println("enter gReverse");
		if (head == null) {
			System.out.println("head == null");
		}else {
			System.out.println(head.val);
		}
		if (head == a) {
			System.out.println("head == a");
		}else {
			System.out.println(a.val);
		}
		System.out.println(a.next);
		if (a == null || a == b || a.next == b) {
			System.out.println("return head!");
			return head;
		}
		// find the previous node of a, which is cur		
		ListNode cur = head;
		System.out.print(head.val);
		System.out.print(a.val);
		if (head == a) {
			cur = null;
		}else {
			while ( cur.next != a) {
				cur = cur.next;
			}
		}
		ListNode pre = b;
		ListNode next = null;
		while (a != b) {
			next = a.next;
			a.next = pre;
			pre = a;
			a = next;
		}
		if (cur != null) 
			cur.next = pre;
		else {
			System.out.print("head is a!");
			return pre;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		ListNode ln = ListNode.build(a);
	    ListNode b = ln;
	    if (ln == b) {
	    	System.out.println("hello!");
	    }
		ListNode.print(ln);
		//ListNode newnode = reverse(ln);
		//ListNode.print(newnode);
		ListNode.print(gReverse(ln, ln, null));
	}

}
