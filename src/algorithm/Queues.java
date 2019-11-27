package algorithm;

import java.util.LinkedList;
import java.util.List;

public class Queues {
	int count = 0;
	int N = 4;
	
	public Queues(int n) {
		N = n;
		List<String> solution = new LinkedList<String>();
		DFS(0,0,0,0);
		
	}
	
	private void DFS(int row, int col, int pie, int na) {
		if (row == N) {
			count ++;
			return;
		}
		//get the bit which can put Q
		int available = ~(col|pie|na) & ((1 << N)-1);
		System.out.println("available columns: " +  Integer.toBinaryString(available));
		//if available = 0, then this try failed.
		while (available > 0) {			
				//get the lowest bit, if we put it here
				int bit = available & -available;
			    System.out.println("let put it in col = " +  Integer.toBinaryString(bit) + " for row " + (row + 1));
				DFS(row + 1, col | bit, bit << 1 , bit >> 1);
				//remove the lowest bit
				available = available & (available - 1);			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queues q = new Queues(8);
		System.out.println(q.count);	
		
	}

}
