package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {
	public static final int len = 20;
	public void check(InputStream in) throws IOException {
		System.out.println("enter check.....");
		int ch = in.read();
		
		int i = 0;
		while (ch != -1) {
			if(ch == 10) {
				i ++;
			}
			ch = in.read();
			System.out.println("i=" + i + ";ch=" + ch);			
		}
		//test(in);
	}
	private void test(InputStream in) throws IOException {
		System.out.println("enter test.....");
		int ch = in.read();
		
		int i = 0;
		while (ch != -1 && i < len) {
			System.out.println(ch);
			ch = in.read();
			i ++;
		}
	}
	public static void main(String[] args) {
		File case1 = new File(HtmlChecker.class.getResource("case1").getPath()); 
		Test test = new Test();
		try {
			InputStream in = new FileInputStream(case1);
			test.check(new FileInputStream(case1));
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
