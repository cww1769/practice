package exam;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class traverseMatrix {

	public void traverse(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int l = m -1 + n -1;
		boolean flag = true;
		for (int i = 0; i <= l; i ++ ) {
			if (flag) {
				flag = false;
				for (int j = 0; j <= i; j ++) {
					if ( j < m && (i-j) < n ) {
						System.out.println(matrix[j][i-j]);
					}
				}
			} else {
				flag = true;
				for (int j = i; j >= 0; j --) {
					if ( j < m && (i-j) < n) {
						System.out.println(matrix[j][i-j]);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		/*traverseMatrix tm = new traverseMatrix();
		int[][] matrix = {{1,2}};
		tm.traverse(matrix);*/
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		Integer i = 1;
		test(i);
		System.out.println("aaaaa" + i);
		//printList(list);
	}
	private  static void test(Integer i) {
		//list = new ArrayList<Integer>();
		i = 6;
		System.out.println("bbbbbbbbbbbb" + i);
	}
	private static void printList(List<Integer> list) {
		System.out.println("begin to print list with size = " + list.size());
		for(Integer i : list) {
			System.out.println(i);
		}
	}

} 
