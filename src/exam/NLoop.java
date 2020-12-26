package exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NLoop {
	
	public void loop(int[] dims) {
		LinkedList<ArrayList<Integer>> ini = new LinkedList<ArrayList<Integer>>();
		int n = dims.length;
		if (n == 0)
			return;
		for (int i = 0; i < dims[0]; i ++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(i);
			ini.push(list);
		}
		
		for (int i = 1; i < n; i ++) {
			//System.out.println(i);
			LinkedList<ArrayList<Integer>> res = new LinkedList<ArrayList<Integer>>();
			while(!ini.isEmpty()) {				
				ArrayList<Integer> e = ini.pop();
				//printList(e);
				for (int j = 0; j < dims[i]; j ++) {					
					ArrayList<Integer> clone = new ArrayList<Integer>();
					clone.addAll(e);
					clone.add(j);
					res.push(clone);
				}
			}
			ini = res;			
		}
		//print the result
		printListList(ini);
		return;
	}
	
	public void printListList(LinkedList<ArrayList<Integer>> listlist) {
		Iterator<ArrayList<Integer>> it = listlist.iterator();
		while(it.hasNext()) {
			ArrayList<Integer> e = (ArrayList<Integer>)it.next();
			printList(e);
		}

	}
	public void printList(List<Integer> list) {
		Iterator it = list.listIterator();
		StringBuilder sb = new StringBuilder("[");
		while (it.hasNext()) {
			sb.append(it.next());
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		int[] dims = {3,3,2,2};
		NLoop nloop = new NLoop();
		nloop.loop(dims);
	}

}
