package algorithm;

public class SlidingWindow {
	
	
	    public int[] maxSlidingWindow(int[] nums, int k) {
	        if (nums == null || nums.length == 0)
	           return new int[0];
	        if (k < 2) 
	            return nums;
	        LinkedList<Integer> window = new LinkedList<Integer>();
	        int[] result = new int[n-k+1];
	        for (int i = 0; i < nums.length(); i ++){
	            if (window != null && window[0] == (i - k)){
	                window.removeLast();
	            }
	            while (window != null && nums[i] > window[-1]) {
	                window.pop();
	            }
	            window.push(i);
	            if (i >= k-1)
	            result[i-k+1] = window[0];
	        }
	        return result;
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
