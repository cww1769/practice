package algorithm;

public class Sqrt {

	public static double sqrt(double x, double accuracy) {
		if(x < 0) {
			return Double.NaN;
		}
		double ans = x;
		while(Math.abs(ans*ans - x) > accuracy) {
			ans = (ans + x/ans)/2;
		}
		return ans;	
	}
	
	public static double sqrt1(double x, double accuracy) {
		if(x < 0) {
			return Double.NaN;
		}
		double x0 = x, x1 = 0.0;
		while(true) {
			x1 = (x0 + x/x0)/2;
			if (x0 - x1 <= accuracy) {
				break;
			}			
			x0 = x1;
		}
		return x1;	
	}
	
	public static double sqrt2(double x, double accuracy) {
		if(x < 0) {
			return Double.NaN;
		}
	
		return bsearch(x, 0, x, accuracy);	
	}
	
	private static double bsearch(double x, double low, double high, double accuracy) {
		double mid = low + (high-low)/2;
		double raw = mid*mid;
		if (Math.abs(raw - x) <= accuracy) {
			return mid;
		}
		if (raw > x) {
			return bsearch(x, low, mid, accuracy);
		}
		return bsearch(x, mid, high, accuracy);
	}

	public static void main(String[] args) {
		System.out.println(sqrt(1, 1e-1));
		System.out.println(sqrt1(1, 1e-1));
		System.out.println(sqrt2(1, 1e-7));
		String a = "123";
		a.equals(anObject)

	}

}
