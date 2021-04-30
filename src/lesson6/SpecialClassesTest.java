package lesson6;

import lesson6.SpecialClassesTest.InnerClass.InnerInnerClass;

public class SpecialClassesTest {
	public static int	x = 10;
	public int  y = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("Hello world");
		Class	cl = InnerClass.class;
		
		System.err.println("Class: "+cl.getName());
		System.err.println("Class: "+cl.getCanonicalName());
		
		SpecialClassesTest	owner = new SpecialClassesTest();
		InnerClass	i = owner.new InnerClass();
		InnerClass	i2 = owner.new InnerClass();
		InnerInnerClass	ii = i.new InnerInnerClass();
		
		i.print();
		i2.print();
		ii.print();
		
		InnerStaticClass	isc = new InnerStaticClass();
		
		MyClass	myClass = new MyClass();
		myClass.call();
		
		final double yy = 12.3;
		
		MyInterface	mi = new MyInterface() {
			int		zz = 120;
			@Override
			public void call() {
				System.err.println("INTERFACE CALL "+zz+" "+yy);
			}
		};
		mi.call();
		
		MyInterface	mi1 = new MyInterface() {
			int		zz = 120;
			
			{
				System.err.println("COnstructor.....");
			}
			@Override
			public void call() {
				System.err.println("INTERFACE CALL "+zz+" "+yy);
			}
		};
		mi.call();
	}

	protected class InnerClass {	// 15%
		protected int z = 100;
		
		public void print() {
			System.err.println("Y="+y);
		}
		
		public class InnerInnerClass {
			public void print() {
				System.err.println("---- Y="+y+", Z="+z);
				InnerClass.this.print();
			}
		}
	}

	protected static class InnerStaticClass { // 85%
		public void print() {
			System.err.println("X="+x);
		}
	}
}

interface MyInterface {
	void call();
}

class MyClass/*$1*/ implements MyInterface { 
	@Override
	public void call() { 
		System.err.println("INterface call");
	}
}