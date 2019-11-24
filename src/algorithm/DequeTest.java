package algorithm;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class DequeTest {

	public static void main(String[] args) {
		LinkedList<Integer> deque = new LinkedList<Integer>();
		//queue: add/pop
		deque.add(1);
		deque.add(2);
		deque.add(3);	
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
