package algorithm;

import java.util.HashMap;
import java.util.Map;

public class GetMaxSubStrLen {

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int L = 0, R = 0;
		int maxLen = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while (R < n ) {
			if (map.containsKey(s.charAt(R))) {
				L = Math.max(L, map.get(s.charAt(R)) + 1);
			}
			map.put(s.charAt(R), R);			
			maxLen = Math.max(maxLen, R-L+1);
			R++;
		}
		return maxLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "i am the one";
        System.out.println(lengthOfLongestSubstring(s));
	}

}
