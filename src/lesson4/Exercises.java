package lesson4;

import java.math.BigInteger;

public class Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("Fact(5)="+factorial(5));
//		System.err.println("3 + 5="+add(3,5));
//		System.err.println("4 * 7="+mul(4,7));
		
		BigInteger bi1 = new BigInteger("1265675342909908890890988328989743098908093409809485098809345099034509834095809845"); 
		BigInteger bi2 = new BigInteger("6230909932487676832898908230989023498908945098094550980943509809843509890438509809345809843590843905890348509809809823509809340983094850938450984095"); 
		System.err.println("bi1*bi2="+bi1.multiply(bi2));
		//BigDecimal;
	}

	public static int factorial(int n) {
		if (n <= 1) {
			return 1;
		}
		else {
			return n * factorial(n-1);
		}
	}
	
//	public static int add(int x, int y) {
//	}
//
//	public static int mul(int x, int y) {
//	}
}
