package lesson6;

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		execute(/*new MyTestInterface() {
//			@Override
//			public void process() {*/
//				
//				System.err.println("ASSA!!!!!");
//	/*		}
//		}*/);
		execute(()->System.err.println("ksdjkjkjdkj"));
		execute(LambdaTest::someMysticMethod
				/*new MyTestInterface() {
//			@Override
//			public void process() {
 * 				someMysticMethod();
 * }
				 */
				);
		
	}

	private static void someMysticMethod() {
		System.err.println("Mystic method call");
	}
	
	private static void execute(MyTestInterface x) {
		x.process();
	}
}

@FunctionalInterface
interface MyTestInterface {
	void process();
	default void call1() {}
}