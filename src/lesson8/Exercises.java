package lesson8;

import java.util.Arrays;

public class Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. String s = "ivanov ivan ivanovich";
		// Make "Ivanov I.I."
		String s = "ivanov ivan ivanovich";
		
		String[] items = s.split(" ");
		System.err.println("Step1: "+Arrays.toString(items));
		
		s = Character.toUpperCase(items[0].charAt(0))+
				items[0].substring(1)+
				' '+
				Character.toUpperCase(items[1].charAt(0))+
				'.'+
				Character.toUpperCase(items[2].charAt(0))+
				'.';
		System.err.println("S: "+s);
		
		String poem = "Заплутала радость где-то:\n" + 
				"Мало солнца, мало света,\n" + 
				"Кружит осень листопадом,\n" + 
				"Лужи сковывая хладом.\n" + 
				"Тихо стонет ветка где-то,\n" + 
				"Лихо гонит тучи ветер,\n" + 
				"Дольше дождик бьётся оземь.\n" + 
				"«Больше влаги», — просит озимь.";
	
		StringBuilder meop = new StringBuilder();
		for (String line : poem.split("\n")) {
			meop.append(reverse(line)).append('\n');
		}		
		System.err.println("MEOP: "+meop);
		
		
		int a = Integer.valueOf("-125");

		String	sum = "12+66+3+1+907";
		// sum ? 
		int isum = 0;
		for (String add : sum.split("\\+")) {
			isum += Integer.valueOf(add);
		}
		System.err.println("Isum="+isum);
		
		String	sum2 = "12+66-5+1-907";
		
		int isum2 = 0;
		for (String add : sum2.replace("-", "+-").split("\\+")) {
			isum2 += Integer.valueOf(add);
		}
		System.err.println("Isum2="+isum2);
		
	}
	
	private static String reverse(String source) {
		final StringBuilder	result = new StringBuilder();
		final String[] words = source.split(" ");
		
		for (int index = words.length-1; index >= 0; index--) {
			result.append(words[index]).append(' ');
		}
		return result.toString();
	}
}
