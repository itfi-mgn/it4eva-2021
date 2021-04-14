package lesson3;

public class ObjectTest extends java.lang.Object {

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public String toString() {
		return "URA!!!!";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object	obj = 10;// new Integer(10); new Object();
		Integer x = 10		// new Integer(10)
				, y = 20	// new Integer(20)
				, z = x + y; // new Integer(x.intValue()+y.intValue())
		int x1 = new Integer(10);	// new Integer(10).intValue();
	
		
		obj.equals(obj);

		int[]	array = new int[(int)(Math.random()*1000)];
		
		array = new int[0];// {2,-3, 5, 6, 227, -4};
		// array.length - размер массива;
		
		int[]	a1 = new int[10], b1 = a1.clone();
		
		System.err.println("a1[0]="+a1[0]);
		System.err.println("b1[0]="+b1[0]);
		
		a1[0] = 100;
		
		System.err.println("a1[0]   ="+a1[0]);
		System.err.println("b1[0]   ="+b1[0]);
		
//		b1 = null;
//		b1 = a1;

		b1[5] = 123;
		
		System.err.println("b1   ="+java.util.Arrays.toString(b1)/*.toString()*/);
	
		for (int index = 0; index < b1.length; index++) {
			System.err.println("b1["+index+"]="+b1[index]);
		}
		for (int value : b1) {
			System.err.println("b1="+value);
		}
		
		int[]	values = new int[] {5,-2,18,0,66};
		
		int sum = 0;
		for (int value : values) {
			sum += value;
		}
		System.err.println("Sum="+sum);
	}

}
