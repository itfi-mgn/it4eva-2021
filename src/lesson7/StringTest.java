package lesson7;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String	s = "";
		
		s += "12345";
		
		System.err.println("Length: "+s.length());
		System.err.println("INdex: "+s.charAt(1));

		System.err.println("FInd first: "+s.indexOf('5'));
		System.err.println("FInd last: "+s.lastIndexOf('5'));

		System.err.println("FInd first: "+s.indexOf("34"));
		System.err.println("FInd last: "+s.lastIndexOf("12"));

		String ss = "1,2,3,4,5";
		int	start = 0;
		
		while ((start = ss.indexOf(',',start)) >= 0) {
			System.err.println("At: "+start);
			start++;
		}
		
		System.err.println("Substring: {"+s.substring(0,2)+"}");
		System.err.println("Substring: {"+s.substring(2)+"}");
		System.err.println("String: {"+s+"}");
		
		System.err.println("Equals: "+s.equals("1235"));
		System.err.println("Equals: "+s.equals("12345"));

		System.err.println("Equals test: "+(s == "12345"));

		String vassya = "vassyA";
		
		System.err.println("Equals test: "+vassya.equalsIgnoreCase("vassya"));
	
		System.err.println("To upper: "+vassya.toUpperCase());
		System.err.println("To lower: "+vassya.toLowerCase());

		System.err.println("COmpare to test: "+vassya.compareTo("vassyA"));
		System.err.println("COmpare to test: "+vassya.compareToIgnoreCase("vassya"));
		
		System.err.println("Starts with: "+vassya.startsWith("va"));
		System.err.println("Ends with: "+vassya.endsWith("yA"));
		System.err.println("Contains: "+vassya.contains("ss"));
		
		System.err.println("REplace: "+vassya.replace("ss","SS"));
		System.err.println("REplace: "+vassya.replace("s",""));
		
		String	re = " test 10 test 20 test 3 test 4 test 5 ";
		
		System.err.println("REplace All: "+re.replaceAll("\\d*",""));

		System.err.println("Split: "+Arrays.toString(re.split(" ")));
		
		System.err.println("Empty: "+re.isEmpty());
		System.err.println("Trim: {"+re.trim()+"}");
		
		switch (vassya/*.hashCode()*/) {
			case "vassyA"/*.hashCode()*/ :
				// if (vassya.equals("vassyA")) {
				System.err.println("--- 1 ---");
				// }
				break;
			case "petr"/*.hashCode()*/ :
				// if (vassya.equals("petr")) {
				System.err.println("--- 2 ---");
				// }
				break;
			default :
				System.err.println("--- 3 ---");
				break;
		}
		
	}

}
