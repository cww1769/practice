package test;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int majority(int[] nums) {
		
		int length = nums.length;
		int ans = nums[0];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}else {
				map.put(num, 1);
			}
			if (map.get(num) > length/2) {
				ans = num;
				break;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		
	}

}
