package algorithm;

import java.util.LinkedList;
import java.util.List;

public class Parenthesis {
	public static List<String> generateParenthesis2(int n) {
		LinkedList<String> result = new LinkedList<String>();		
		recursiveGen(result, "", 0, 0, n);		
		return result;
	}
	//cur is just like a node in the tree, if can be added a "left" or a "right"
	private static void recursiveGen(List<String> result, String cur, int left, int right, int n) {
		System.out.println(left + "#" + right);
		if (left == n && right == n) {
			
			System.out.println(cur);
			result.add(cur);
			return;
		}
		if (left < n) {
			//wrong!!!!! you can not change cur, otherwise the cur in next if will has an extra "("     cur = cur + "(";			
			recursiveGen(result, cur + "(", left +1 , right, n);
		}
		if (right < n && left > right) {
			//cur = cur + ")";
			recursiveGen(result, cur + ")", left , right + 1, n);
		}
		
	}
    public static List<String> generateParenthesis(int n) {
        LinkedList<String> result = new LinkedList<String>();
        LinkedList<int[]> usedList = new LinkedList<int[]>();        
        if (n==0) {
            return result;
        }
        result.add("(");
        usedList.add(new int[]{1,0});
        int level = 1;
        while (level <= 2*n - 1) {
            int size = result.size();
            System.out.print(level + "#");
            System.out.println(size);
            for (int i = 0; i < size; i ++) {
                String s = result.pop();
                System.out.println(s);
                int[] used = usedList.pop();    
                int left = used[0];
                int right = used[1];
                System.out.println(left + "=====" + right);
                if (left < n) {
                    result.add(s + "(");
                    int newUsed = left + 1;
                    usedList.add(new int[]{newUsed, right});
                }                
                if (right < n && left > right) {
                    result.add(s + ")");
                    int newUsed = right + 1;
                    usedList.add(new int[]{left, newUsed});
                }
            }
            level ++;
        }
        return result;
    }

	public static void main(String[] args) {
		List<String> a = generateParenthesis2(3);
		System.out.println("&&&&&&&");
		for (String s: a) {
			System.out.println(s);
		}

	}

}
