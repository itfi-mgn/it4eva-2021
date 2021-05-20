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
				
	}

}
