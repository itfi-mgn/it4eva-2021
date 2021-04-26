package lesson5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {
	public static void simulateProblem(int x) throws Exception, Throwable {
		switch (x) {
			case 0 :
				throw new RuntimeException("RUntime detected!!!!");
			case 1 :
				throw new Exception("Exception detected!!!!");
			case 2 :
				throw new Throwable("Throwable detected!!!!");
			default :
				;
		}
	}
	
	public static void proxy(int x) throws Throwable {
		try {simulateProblem(x);
		} catch (Exception exc) {
			System.err.println("Exceptrion !!!!!!! "+exc.getMessage());
		} finally {
			System.err.println("=========================");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Throwable	t = new Throwable();
		for (int i = 0; i <= 3; i++) {
			try{
				proxy(i);
				System.err.println("Success");
			} catch (RuntimeException e) {
				System.err.println("Process runtime exception: "+e.getMessage());
			} catch (Exception e) {
				System.err.println("Process exception: "+e.getMessage());
			} catch (Throwable e) {
				System.err.println("Process throwable: "+e.getMessage());
			} finally {
				System.err.println("--------------");
			}
		}
		
	}

}
