package algorithm;

public class QSort {

	public void qsort(int[] nums, int start, int end) {
		if (start < end) {
			int i = partition(nums, start, end);
			qsort(nums, start, i-1);
			qsort(nums, i+1, end);
		}		
	}
	
	public int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		System.out.println("pivot = " + pivot);
		
		int left = start;
		int right = end;
		while(left < right) {
			while(nums[left] <= pivot && left < right) {
				left ++;
			}
			while(nums[right] >= pivot && left < right) {
				right --;
			}
			if (left < right) {
				swap(nums, left, right);
			}
		}		
		swap(nums, left, end);
		print(nums, start, end);
		System.out.println("index = " + left);
		return left;
	}
	public void swap(int[] nums, int i, int j) {
		System.out.println("swap i = " + i + " j = " + j);
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	public void print(int[] nums, int start, int end) {
		System.out.println("begin to print from start = " + start + "; end = " + end);
		for (int i = start; i <= end; i ++ ) {
			System.out.print(nums[i] + " ");
		}		
		System.out.println("");
	}
	public static void main(String[] args) {
		int[] nums = {10,9,8,6};
		
		QSort qsort = new QSort();
		qsort.qsort(nums, 0, nums.length - 1);
		qsort.print(nums, 0, nums.length - 1);
	}

}
