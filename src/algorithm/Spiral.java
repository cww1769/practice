package algorithm;

public class Spiral {
	
	static int a[][] = null;
	static int Len = 0;
	static int p = 1;
	public Spiral(int length) {
		System.out.println("create spiral");
		Len = length;
		int n = Len;
		a = new int[n][n];		
		int move = 0;
		while (n > 0) {
			locate(n, move);
			n = n - 2;			
			move ++;
		}
		
	}
	
	private static void locate(int n, int move) {
		System.out.println(n);
		System.out.println(move);
		int i= 0,j = 0;
		for (j = 0; j < n; j++ ) {
		    a[i + move][j + move] = p++;
		    System.out.println(a[i + move][j + move]);
		}
		if (n > 1) {
			j = n-1;
			for (i = 1; i < n; i++ ) {
				a[i + move][j + move] = p++;
				System.out.println(a[i + move][j + move]);
			}
			i = n-1;
			for (j = n-2; j >= 0; j --) {
				a[i + move][j + move] = p++;
				System.out.println(a[i + move][j + move]);
			}
			j = 0;
			for (i = n-2; i > 0; i --) {
				a[i + move][j + move] = p++;
				System.out.println(a[i + move][j + move]);
			}
		}		
	}

    
    private void output() {
    	System.out.println("begin output!");
    	for (int i = 0; i < Len; i ++) {
    		String tmp = "";
    		for (int j = 0; j < Len; j ++) {
          		tmp = tmp + " " + a[i][j];
    		}
    		System.out.println(tmp);
    	}
    	
    }
	public static void main(String[] args) {
		
        Spiral s =  new Spiral(4);
        s.output();
        
	}
	

}
