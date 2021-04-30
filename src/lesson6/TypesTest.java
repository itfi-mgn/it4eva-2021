package lesson6;

public class TypesTest<T extends Number, T1 extends Number> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TypesTest<Integer,Long>().add(3,5L);
		new TypesTest<Long,Long>().add(3L,5L);
		new TypesTest<Float,Double>().add(3.0f,5.0d);
	}

	public Number add(T x, T1 y) {
		return (x.intValue()+y.intValue());
	}
}
