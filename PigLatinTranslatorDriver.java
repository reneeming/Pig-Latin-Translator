/**
@author Ming Ni
@version 1.0

COP5007 Project #: 1
File Name: PigLatinTranslatorDriver.java
*/

import java.util.*;

public class PigLatinTranslatorDriver {

	/**
	Provide a loop that continuously prompts a user for new Strings to translate
	and the set of accepted vowels until the user types in vowels.
	*/
	public static void main(String[] args) {
		//testPigLatinTranslator();
		System.out.println("Welcome to the Pig Latin Translator");
		PigLatinTranslator plt = new PigLatinTranslator();        

		while(true) {
			Scanner scan = new Scanner(System.in);
	        System.out.println("Enter a String to Translate");
	        String input = scan.nextLine();
	        if (input.equals("exit")) {
		        System.out.println("Goodbye!");
	        	break;
	        }
	        System.out.println("Enter a String to Represent vowels");
	        String vowels = scan.nextLine();
	        plt.setVowels(vowels);
	        String got = plt.translateString(input);
	        System.out.println("Translated String: " + got);        
		}
        
	}
	
	/**
	This test include 6 test cases, which fully test the PigLatinTranslator class. 
	*/
	public static void testPigLatinTranslator() {
		/**
		Test default constructor and get method.
		*/
		System.out.println("============Testing default constructor and get method=============");
		PigLatinTranslator plt = new PigLatinTranslator();
		if (plt.getVowels().equals("aeiou")) {
		    System.out.println("Test successful, got: \"" + plt.getVowels() + "\"");
		} else {
			System.out.println("Test failed, want: \"aeiou\", but got: \"" + plt.getVowels() + "\"");
		}
		
		/**
		Test parametered constructor and get method.
		*/
		System.out.println("============Testing default constructor and get method=============");
		plt = new PigLatinTranslator("xyz");
		if (plt.getVowels().equals("xyz")) {
		    System.out.println("Test successful, got: \"" + plt.getVowels() + "\"");
		} else {
			System.out.println("Test failed, want: \"xyz\", but got: \"" + plt.getVowels() + "\"");
		}
		
		/**
		Test default vowels and translateString method.
		*/
		Map<String, String> translateStringTests = new HashMap<>();
		translateStringTests.put("translate the pig latin", "anslatetray ethay igpay atinlay");
		translateStringTests.put("egg is happy", "eggay isay appyhay");
		translateStringTests.put("thanks", "anksthay");
		translateStringTests.put("omelet", "omeletay");
		translateStringTests.put("my", "myay");
		translateStringTests.put("", "");
		
		plt = new PigLatinTranslator();
		System.out.println("============Testing translateString method=============");
		for (String input: translateStringTests.keySet()) {
			System.out.println("Testing input: " + input);
			String got = plt.translateString(input);
			String want = translateStringTests.get(input);
			if (got.equals(want)) {
			    System.out.println("Test successful, got: \"" + got + "\"");
			} else {
				System.out.println("Test failed, want: \"" + want + "\", but got: \"" + got + "\"");
			}
		}
		
		/**
		Test set and get.
		*/
		List<String> setAndGetVowelsTests = new ArrayList<>();
		setAndGetVowelsTests.add("");
		setAndGetVowelsTests.add("aeiou");
		setAndGetVowelsTests.add("q");
		
		System.out.println("============Testing set and get vowels=============");
		for (String input: setAndGetVowelsTests) {
			plt.setVowels(input);
			if (plt.getVowels().equals(input)) {
			    System.out.println("Test successful, got: \"" + input + "\"");
			} else {
				System.out.println("Test failed, want: \"" + input + "\", but got: \"" + plt.getVowels() + "\"");
			}
		}

		/**
		Test set new vowels `uvw` and translateString method.
		*/
		translateStringTests = new HashMap<>();
		translateStringTests.put("unique group", "uniqueay upgroay");
		translateStringTests.put("group", "upgroay");
		translateStringTests.put("", "");
		
		System.out.println("============Testing set new vowels `uvw` and translateString method=============");
		plt.setVowels("uvw");
		for (String input: translateStringTests.keySet()) {
			System.out.println("Testing input: " + input);
			String got = plt.translateString(input);
			String want = translateStringTests.get(input);
			if (got.equals(want)) {
			    System.out.println("Test successful, got: \"" + got + "\"");
			} else {
				System.out.println("Test failed, want: \"" + want + "\", but got: \"" + got + "\"");
			}
		}
	}

}
