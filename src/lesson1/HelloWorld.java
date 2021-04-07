package lesson1;

//import java.lang.*;
//import lesson1.*;

public class HelloWorld /*extends java.lang.Object*/ {
	protected static int		x;
	protected int y;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*java.lang.*/
		System.err.println("Hello world!");
		byte	b1 = 10, b2 = 20, b3 = (byte)(b1 + b2);
		
		System.err.println("b1+b2="+(b1+b2));
		System.err.println("b1-b2="+(b1-b2));
		System.err.println("b1*b2="+(b1*b2));
		System.err.println("b1/b2="+(b1/b2));
		System.err.println("b1%b2="+(b1%b2));

		short	s1 = 10, s2 = 20;
	
		int		i1 = 10, i2 = 20;

		long	l1 = 10, l2 = 20;
	
		float	f1 = 10, f2 = 20;
		
		System.err.println("f1+f2="+(f1+f2));
		System.err.println("f1-f2="+(f1-f2));
		System.err.println("f1*f2="+(f1*f2));
		System.err.println("f1/f2="+(f1/f2));
		System.err.println("f1%f2="+(f1%f2));

		double	d1 = 10, d2 = 20;
//		System.err.println("d1/d2="+(d1/d2));
	
		System.err.println("i1 | i2="+(i1 | i2));
		System.err.println("i1 & i2="+(i1 & i2));
		System.err.println("i1 ^ i2="+(i1 ^ i2));
		System.err.println("~i1 "+(~i1));

		i1 = -10;
		System.err.println("i1 << 1="+(i1 << 2));
		System.err.println("i1 >> 1="+(i1 >> 2));
	
		System.err.println("i1 >>> 1="+(i1 >>> 2));
		
		
//		System.err.println("x="+x);
	}

}
