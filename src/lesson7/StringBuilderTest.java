package lesson7;

public class StringBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder	sb = new StringBuilder();
		
		System.err.println("COntent: {"+sb+"}");
		// new StringBuilder("COntent : {").append(sb.toString())
		//     .append("}").toString()
		sb.append("test ").append(100).append('=').append(false);
		System.err.println("COntent [2]: {"+sb+"}");
	
		String	r = "";
		for (int index = 0; index < 10; index++) {
			r += index +" ";
		}
		System.err.println("R="+r);

		sb.setLength(0);
		for (int index = 0; index < 10; index++) {
			sb.append(index).append(" ");
		}
		System.err.println("R [2]="+sb);
	
	}

}
