package lesson5;

public class InterfaceTest implements MyInterface {
	public void print() {
		System.err.println("sldklskdlk");
	}
	
	public static void main(String[] args) {
		InterfaceTest	it = new ChildInterfaceTest();
		
		callPrint(new Abcde());
	}

	public static void callPrint(/*InterfaceTest*/MyInterface it) {
		it.print();
		it.callNewMethod();
	}
}

interface MyInterface {
	default void print() {}
	default void callNewMethod() {
		System.err.println("dfklgjlkfjergoiu09rt8");
	}
}

class ChildInterfaceTest extends InterfaceTest {
	public void print() {
		System.err.println("iidfguklfd-092380984095sldklskdlk");
	}
}

class Abcde implements MyInterface {
	protected void zzz() {
		
	}
	
	public void sdfsdf() {
		
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.err.println("1232352345sdgfhgdfghdfhdjkkjfdhkjdfhkjfdkjghkjfdh");
	}

//	@Override
//	public void callNewMethod() {
//		System.err.println("dfklgjlkfjergoiu09rt8");
//	}

}

interface I1 {
	/*public static final */ int x = 10;
	void m1();
	void m2();
}

interface I2 {
	void m2();
	void m3();
}

interface I3 extends I1,I2 {
	// void m1();
	// void m2();
	// void m3();
}


