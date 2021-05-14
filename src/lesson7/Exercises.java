package lesson7;

public class Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  s = "abcdefg";
		// s = "AbCdEfG";
		String	result = "";	// 1!!
		
		for (int index = 0; index < s.length(); index++) {
			if (index % 2 == 0) {
				result += s.substring(index,index+1).toUpperCase();
			}
			else {
				result += s.substring(index,index+1).toLowerCase();
			}
		}
		System.err.println("Result: "+result);
		
		StringBuilder	sb = new StringBuilder();
		for (int index = 0; index < s.length(); index++) {
			if (index % 2 == 0) {
				sb.append(s.substring(index,index+1).toUpperCase());
			}
			else {
				sb.append(s.substring(index,index+1).toLowerCase());
			}
		}
		System.err.println("Result: "+sb.toString());
		
		StringBuilder	sb2 = new StringBuilder();
		for (int index = 0; index < s.length(); index++) {
			if (index % 2 == 0) {
				sb2.append(Character.toUpperCase(s.charAt(index)));
			}
			else {
				sb2.append(Character.toLowerCase(s.charAt(index)));
			}
		}
		System.err.println("Result: "+sb2.toString());
		
		char[]	content = s.toCharArray();
		int		index;
		
		for (index = 0; index < content.length-1; index+=2) {
			content[index] = Character.toUpperCase(content[index]);
			content[index+1] = Character.toLowerCase(content[index+1]);
		}
		if (content.length % 2 > 0) {
			content[index] = Character.toUpperCase(content[index]);
		}
		System.err.println("Result: "+new String(content));
		
		
		// String	a = "1 2 3 4 5 6 7 8 9";
		// a = "1 2  3   4    5     6      7       8        9         ";
	}

}
