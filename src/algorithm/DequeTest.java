package algorithm;

import java.util.LinkedList;

public class DequeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> deque = new LinkedList<Integer>();
		//queue: add/pop
		deque.add(1);
		deque.add(2);
		deque.add(3);		
		System.out.println(deque.pop());
		//stack: push/pop
		deque.push(4);
		System.out.println(deque.pop());
		
		//deque: push/pop for front and add/removeLast for rear
		deque.add(5);
		System.out.println(deque.removeFirst());
		
	}

}
