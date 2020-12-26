package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HtmlChecker {
	private static final int LF = 10;
	private static final int CR = 13;
	private static final int maxTAGLen = 10;
	
	public void check(InputStream in) throws IOException {
		int caseIndex = 1;
		int lineNumOfCase = getLineNum(in);
		
		while (lineNumOfCase > 0) {
			System.out.println("Test Case " + caseIndex + "\n" + checkCase(lineNumOfCase, in));
			lineNumOfCase = getLineNum(in);
			caseIndex ++;
		}		
		
	}
	
	public static boolean isUpperCase(int ch) {
		if (ch >= 'A' && ch <= 'Z') {
			return true;
		}
		return false;
	}
	public static boolean isDigit(int ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		return false;
	}
	private int getLineNum(InputStream in) throws IOException{
		System.out.println("enter getLineNum");
		int c = in.read();
		System.out.println("first c=" + c);
		List<Integer> list = new ArrayList<Integer>();
		int lineNum = 0;
		while (c != CR) {
			System.out.println(c);
			list.add(c-'0');
			c = in.read();			
		}
		for (int i = 0; i < list.size(); i ++) {
			//System.out.println(i);
			//System.out.println(list.get(i));
			lineNum += list.get(i)*Math.pow(10,(list.size()-i-1));
		}
		System.out.println("exit getLineNum");
		return lineNum;
	}
	
	private String checkCase(int lineNum, InputStream in) throws IOException {
		System.out.println("enter checkCase with lineNum = " + lineNum);
		String output = "OK";
		LinkedList<String> stack = new LinkedList<String>();
	    int curChar = in.read();	    
	    int curLine = 1;
	    boolean success = true;
		while(curChar != -1 && curLine <= lineNum) {
			//System.out.println("curChar = " + curChar);
			if (curChar == CR) {				
				curLine ++;
				System.out.println("curLine = " + curLine);
			}
			if (success != false) {
			if (curChar == '<') {
			    int next = in.read();
			    if (next == '/') {
			    	System.out.println("meet </, see if there is a pair in the stack");
			    	String expected = stack.poll();
			    	if (expected == null) {
			    		output = ("line " + curLine + "no mactching begin tag");
			    		success = false;
			    	} else {
			    		for (int i = 0; i < expected.length(); i ++) {
			    			char expected_char = expected.charAt(i);
			    			int real_char = in.read();
			    			if (expected_char != real_char) {
			    				output = ("line " + curLine + " expected </" + expected + ">");
			    				success = false;
			    			}
			    		}
			    		if (in.read() != '>') {
			    			output = ("line " + curLine + " expected </" + expected + ">");
			    			success = false;
			    		}
			    	}			    	
			    } else {
			    	System.out.println("meet <, put it in the stack");
			    	char[] tag = new char[maxTAGLen];
			    	int realLen = 0;			    	
			    	while (next != '>' && realLen < maxTAGLen) {
			    		if (isUpperCase(next)) {
			    			tag[realLen] = (char)next;
			    			next = in.read();
			    			realLen ++;
			    		} else {
			    			output = ("line " + curLine + " bad character in tag name");
			    			success = false;
			    			break;
			    		}
			    	}
			    	
			    	if (realLen == 0 || realLen == 10) {
			    		output = ("line " + curLine + " too many/few characters in tag name");
			    		success = false;
			    	} else {
			    		String tagString = String.valueOf(tag).substring(0, realLen);
			    		stack.push(tagString);
			    	}
			    	
			    }
			}			
			}
			curChar = in.read();
		}
		if (success == true && !stack.isEmpty()) {
			output = ("line " + lineNum + " expected </" + stack.poll() + ">");
			success = false;
		}
		return output;
	}
	

	public static void main(String[] args) {
		HtmlChecker checker = new HtmlChecker();
		File case1 = new File(HtmlChecker.class.getResource("case1").getPath()); 
		
		try {
			InputStream in = new FileInputStream(case1);
			checker.check(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		 
	}

}
