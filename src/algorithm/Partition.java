package algorithm;

public class Partition {

	public void partition(int[] nums) {
		if (nums == null || nums.length == 0 ) {
			return;
		}
		int length = nums.length;
		int left = 0, right = length-1;
		while (left < right) {
			while (func(nums[left])) {
				left ++;
			}
			while (!func(nums[right])) {
				left --;
			}
			if (left < right) {
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
			}
		}
	}
	public boolean func(int num) {
		if (num != 0)
			return true;
		return false;
	}
	 
	public void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
	
	public static void main(String[] args) {
		

	}

}
