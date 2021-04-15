package lesson4;

public class ChildLifeCycleTest extends LifeCycleTest {
	public int	z = 30;
	public int zzzzz;
	
	// public void <init>() {
	//		super.<init>();
	//		z = 30;
	//	System.err.println("COnstruction dlfkjksdgjlkdfjglkj!");
	// }
	
	public ChildLifeCycleTest() {
		// super.<init>();
		// z = 30;
		//	System.err.println("COnstruction dlfkjksdgjlkdfjglkj!");
		System.err.println("1234558560-dgkldgfkhdfgo");
	}

	public ChildLifeCycleTest(int zzzzz) {
		// super.<init>();
		// z = 30;
		//	System.err.println("COnstruction dlfkjksdgjlkdfjglkj!");
		System.err.println("1234558560 ****** dgkldgfkhdfgo");
		z = zzzzz;
		this.zzzzz = zzzzz;
	}
	
//	{
//		System.err.println("COnstruction dlfkjksdgjlkdfjglkj!");
//	}	
	
	public static void statPrint() {
		System.err.println("CHILD Print static father "+/*LifeCycleTest.*/x);
	}
	
	public  void nonStatPrint(/*this*/ int abcde) {
		System.err.println("CHILD Print non-static father "+this.z);
	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LifeCycleTest clct = new ChildLifeCycleTest(12345);

//		System.err.println("Z="+clct.z+", Y="+clct.y);
		clct.statPrint();	// ChildLifeCycleTest.statPrint();
		clct.nonStatPrint(12345);
		
		clct = null;
		
//		LifeCycleTest.main(args);
	}

}
