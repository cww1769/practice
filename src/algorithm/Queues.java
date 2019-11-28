package algorithm;

import java.util.LinkedList;
import java.util.List;

public class Queues {
	int count = 0;
	int N = 4;
	List<List<String>> solution = new LinkedList<List<String>>();

	public Queues(int n) {
		N = n;
		DFS(0, 0, 0, 0, new LinkedList<String>());
		printSolution(solution);
	}
	public static void printList(List<String> l) {
		System.out.println("print the list with size = " + l.size());
		for (int i = 0; i < l.size(); i ++ ) {
			System.out.println(l.get(i));
		}
	}
	public static void printSolution(List<List<String>> ll) {
		System.out.println("print the solution with size = " + ll.size());
		for (int i = 0; i < ll.size(); i ++ ) {
			printList(ll.get(i));
		}
	}
	private void DFS(int row, int col, int pie, int na, LinkedList<String> s) {
		if (row == N) {
			count++;
			solution.add(ok);
			return;
		}
		// get the bit which can put Q
		int available = ~(col | pie | na) & ((1 << N) - 1);
		System.out.println("available columns: " + Integer.toBinaryString(available) + " for row " + (row + 1));
		while (available > 0) {
			// get the lowest bit, if we put it here
			int bit = available & -available;
			// fill the solution list
			s.add(getBits(bit, N));
			System.out.println("let put it in col = " + Integer.toBinaryString(bit) + " for row " + (row + 1));
			DFS(row + 1, col | bit, bit << 1, bit >> 1, s);
			// remove the lowest bit
			available = available & (available - 1);
		}
	}

	// from lowest to highest bit, bit must be > 1
	public static String getBits(int bits, int N) {
		StringBuilder s = new StringBuilder();
		for (int i = N - 1; i >= 0; i--) {
			if (((bits >> i) & 1) == 1) {
				s.append("Q");
			} else {
				s.append(".");
			}
		}
		return s.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queues q = new Queues(5);
		System.out.println(q.count);
		printSolution(q.solution);

	}

}
