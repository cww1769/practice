package algorithm;


public class ListNode {
	int val;
	ListNode next;
	ListNode(int v){
		val = v;
	}
	
	public static void print(ListNode head) {
		ListNode p = head;
		while (p != null) {
			if (p.next == null) {
				System.out.print(p.val + "\n");
			}else {
			   System.out.print(p.val + "->");
			}
			p = p.next;
		}
	}
	
	public static ListNode build(int[] a) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		for (int i = 0; i < a.length; i ++) {
			p.next = new ListNode(a[i]);
			p = p.next;
		}
		return dummy.next;
	}
}
