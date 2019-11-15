package algorithm;


import java.util.LinkedList;
/******
 * 
 * @author wvchen
 * NOTE:  for loop, need to remember the limit must be constant, do not use res.size() but still add to res 
 *
 */
public class GetAllSubString {

	private static LinkedList<String> res = new LinkedList<String>();

	public static void main(String args[]) {
		calAllSub("abcd");
		for(int i = 0; i < res.size(); i++){
			 System.out.println(res.get(i));			 
        }
	}

	private static void calAllSub(String s) {

		int n = s.length();
		if (n == 0) return;
		if (n == 1) {
			res.add(s);
		} else {
			calAllSub(s.substring(0, n - 1));
		    int size = res.size();
			for (int i = 0; i < size; i++) {
				res.add(res.get(i) + s.substring(n - 1, n));
			}
			res.add(s.substring(n - 1, n));
		}
	}

}
