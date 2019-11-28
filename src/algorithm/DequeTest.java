package algorithm;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;


public class DequeTest {
	
	
	public static void printList(List<Integer> l) {
		System.out.println("print the list with size = " + l.size());
		for (int i = 0; i < l.size(); i ++ ) {
			System.out.println(l.get(i));
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> deque = new LinkedList<Integer>();
	    LinkedList<int[]> a = new LinkedList<int[]>();
	    int[] a1 = {1,2};
	    a.add(new int[] {1,2});
	    
		//queue: add/pop
		
		deque.add(1);
		deque.add(2);
		deque.add(3);	
		printList(deque);
		System.out.println(deque.pop());
		System.out.println("aaaaa=" + deque.size());
		for (int i = 0; i < 3; i ++)
			System.out.println(deque.removeFirst());
		System.out.println("bbbbb=" + deque.size());
		
		
		for (int i = 0;  i < deque.size(); i ++) {
			System.out.println(deque.get(i));
		}
		System.out.println(deque.getFirst());
		System.out.println(deque.pop());
		//stack: push/pop
		deque.push(4);
		System.out.println(deque.pop());
		
		//deque: push/pop for front and add/removeLast for rear
		deque.add(5);
		System.out.println(deque.removeFirst());
		
		System.out.println("======");
		ArrayDeque<Integer> deque2 = new ArrayDeque<Integer>();
		//queue: add/pop
		deque2.add(1);
		deque2.add(2);
		deque2.add(3);	
		deque2.offer(8);
		System.out.println(deque2.getFirst());
		System.out.println(deque2.getLast());
		System.out.println(deque2.pop());
		//stack: push/pop
		deque2.push(4);
		System.out.println(deque2.pop());
		
		//deque: push/pop for front and add/removeLast for rear
		deque2.add(5);
		System.out.println(deque2.removeFirst());
		
		
		
	}

}
