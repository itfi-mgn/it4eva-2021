package lesson4;

public class LifeCycleTest /*extends java.lang.Object*/{
	public static int	x = 10;
	public int			y = 20;
	
	// public void <clinit>(){
	//		x = 10;
//	System.err.println("URA!!!!!!!!");
//	System.err.println("1234657");
	// }
	
	static {
		System.err.println("URA!!!!!!!!");
	}
	
	// public void <init>() {
	//		super.<init>();
	//		y = 20;
	//		System.err.println("COnstruction father!");
	// }
	
	
	{
		System.err.println("COnstruction father!");
	}
	
	public static void statPrint() {
		System.err.println("Print static father "+/*LifeCycleTest.*/x);
	}
	
	public  void nonStatPrint(/*this*/ int abcde) {
		System.err.println("Print non-static father "+this.y);
	}
	
	
	public void call() {
		nonStatPrint(12345);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("Hello world "+/*LifeCycleTest.*/x);
		
		LifeCycleTest	lct = new LifeCycleTest(),
						lct2 = new ChildLifeCycleTest();
		
		System.err.println("Y="+lct.y);
		lct.statPrint();	// LifeCycleTest.statPrint();
		
		lct.y = 100;
		lct2.y = 200;
		
		lct.nonStatPrint(/*lct*/5);
		lct2.nonStatPrint(/*lct2*/5);

		lct.call();
		lct2.call();
	}

	static {
		System.err.println("1234657");
	}
	
}
