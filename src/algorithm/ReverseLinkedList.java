package algorithm;



public class ReverseLinkedList {
    
	public static class LinkedNode {
		int val;
		LinkedNode next;
		LinkedNode(int v){
			val = v;
		}
		
	}
	
	public static void print(LinkedNode head) {
		LinkedNode p = head;
		while (p != null) {
			if (p.next == null) {
				System.out.print(p.val + "\n");
			}else {
			   System.out.print(p.val + "->");
			}
			p = p.next;
		}
	}
	
	public static LinkedNode build(int[] a) {
		LinkedNode dummy = new LinkedNode(0);
		LinkedNode p = dummy;
		for (int i = 0; i < a.length; i ++) {
			p.next = new LinkedNode(a[i]);
			p = p.next;
		}
		return dummy.next;
	}
	public static LinkedNode reverse(LinkedNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		LinkedNode pre = null;
		LinkedNode next =null;
		while (head != null) {
			next = head.next;
		    head.next = pre;
		    pre = head;
		    head = next;
		}
		return pre;
		
	}
	public static void main(String[] args) {
		int[] a = {1,2,3};
		LinkedNode ln = build(a);
		print(ln);
		print(reverse(ln));
	}

}
