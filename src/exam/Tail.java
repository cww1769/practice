package exam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Tail {
	private static final int LF = 10;
	private static final int CR = 13;
	public void tail(String filename, long n) throws FileNotFoundException,IOException {
		System.out.println("begin to print the last " + n + " lines of file " + filename);
		if (n <= 0) {
			System.out.println("");
			return;
		}
		RandomAccessFile myFile = new RandomAccessFile(filename, "r");
		long fileLength = myFile.length();
		if (fileLength == 0) {
			System.out.println("");
			myFile.close();
			return;
		}
        
        long curLine = 0;
        long pos = fileLength - 1;
        //move the pointer to file end and then back to the start pos of the last n
        while (curLine < n && pos > 0 ) {
        	myFile.seek(pos);
        	int ch = myFile.read();
        	if (ch == LF) {
        		curLine ++;
        	}
        	pos --;
        }
        //output the last n lines
        String line = myFile.readLine();
        while ( line != null) {
        	System.out.println(line);
        	line = myFile.readLine();
        }
        myFile.close();
		return;
	}

	public static void main(String[] args) {
		Tail tail = new Tail();
		long n = -1;
		try {
			tail.tail(Tail.class.getResource("empty.txt").getPath(), n);
			tail.tail(Tail.class.getResource("one-line.txt").getPath(), n);
			tail.tail(Tail.class.getResource("large.txt").getPath(), n);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
