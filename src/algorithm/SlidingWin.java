package algorithm;

import java.util.LinkedList;


public class SlidingWin {
	
    public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0)
       return new int[0];
    if (k < 2) 
        return nums;
    int n = nums.length;
    LinkedList<Integer> window = new LinkedList<Integer>();
    int[] result = new int[n-k+1];
    for (int i = 0; i < n; i ++){
        if (window != null && window.size() > 0 && window.getFirst() == (i - k)){
            window.removeFirst();
        }
        while (window != null && window.size() > 0 && nums[i] > nums[window.getLast()]) {
            window.removeLast();
        }
        window.add(i);
        if (i >= k-1)
            result[i-k+1] = nums[window.getFirst()];
    }
    return result;
}
	public static void main(String[] args) {
		int[] nums = {7,3,-1,-3,5,3,6,7};
		int k = 3;
        //int[] res = maxSlidingWindow(nums, k);
		/*for (int i = 0; i < res.length; i ++) {
        	System.out.println(res[i]);
        }*/
		LinkedList<Integer> window = new LinkedList<Integer>();
	    window.add(1);
	    window.add(2);
	    window.add(3);
	    window.push(6);
	    System.out.println(window.pop());
        
	}

}
