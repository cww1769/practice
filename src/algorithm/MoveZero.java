package algorithm;

public class MoveZero {
	   public void moveZeroes(int[] nums) {
	        if (nums == null || nums.length == 0)
	            return;
	        int zero = 0;
	        int fast = 0;
	        while(fast < nums.length) {
	            if (nums[zero] != 0) {
	                zero ++;
	            } 
	            if (nums[fast] != 0 && zero < fast) {
	                nums[zero] = nums[fast];
	                nums[fast] = 0;
	            }        
	            fast ++;
	        }
	        
	    }
}
