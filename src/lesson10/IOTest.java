package lesson10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;

public class IOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (InputStream	is = new FileInputStream("c:/temp/zzz.txt");
			Reader			rdr = new InputStreamReader(is,"cp866");
			BufferedReader	brdr = new BufferedReader(rdr)) {
//			char[]	buffer = new char[100];
//			
//			int	len = rdr.read(buffer,0,100);
//			
//			System.err.println("len="+len);
//			System.err.println("buffer="+Arrays.toString(buffer));
//			
//			System.err.println("String: "+new String(buffer,0,len));
			System.err.println("Line="+brdr.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		try (OutputStream	os = new FileOutputStream("c:/temp/yyy.txt");
			PrintWriter		ps = new PrintWriter(os)) {
			
			ps.println("вася");
			ps.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
