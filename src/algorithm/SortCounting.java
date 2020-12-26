package algorithm;

public class SortCounting {

	private static int num = 0;
	
	private static void mergeSortCounting(int[] a, int p, int r) {
		if (p >= r) return;
		int q = p + (r-p)/2;
		mergeSortCounting(a, p, q);
		mergeSortCounting(a, q+1, r);
		merge(a, p, q, r);
		System.out.println("num=" + num + "; p=" + p +"; q="+q+"; r="+r);
		
	}
	
	private static void merge(int[] a, int p, int q, int r) {
		int i = p,j = q+1,k = 0;
		int[] tmp = new int[r-p+1];
		while (i <= q && j <= r) {
			if(a[i] <= a[j]) {
				tmp[k++] = a[i++];
			}else {
				num += (q-i+1);
				tmp[k++] = a[j++];
			}
		}
/*		while(i <=q) {
			tmp[k++] = a[i++];
		}
		while(j <= r) {
			tmp[k++] = a[j++];
		}
		for(i = 0; i <= r-p; i ++) {
			a[p+i] = tmp[i];
		}*/
	}
	
	
	public static void main(String[] args) {		
		int n = 6;
		int a[] = {2,4,3, 1, 5, 6};
		//int a[] = {1,2,3,4,5,6};
		//int a[] = {6,5,4,3,2,1};
		mergeSortCounting(a, 0, n-1);
		System.out.println("逆序=" + num);
	}

}
 