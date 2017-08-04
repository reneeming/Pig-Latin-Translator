/**
@author Ming Ni
@version 1.0

COP5007 Project #: 1
File Name: PigLatinTranslator.java
*/

import java.util.ArrayList;
import java.util.List;

public class PigLatinTranslator {
	/**
	Instance of the vowels, each character in this String will be considered a vowel.
	*/
	private String vowels;
	
	/**
	 Default constructor that will set all vowels to the standard vowels.
	 */
	PigLatinTranslator() {
		vowels = "aeiou";
	}
	
	/**
	Parameterized constructor that accepts a String representing the letters that count as
	vowels. For instance, if instead of vowels, you also wanted `y`, then call the constructor
	with vowels `aeiouy`
	* @param val
	*/
	PigLatinTranslator(String val) {
		vowels = val;
	}
	
	/**
	Take in a String to translate to Pig Latin.
	@param sentence
	@return the result of translation for sentence
	*/
	public String translateString(String sentence) {
		String[] words = sentence.split(" +");
		List<String> res = new ArrayList<>();
		for (String word: words) {
			res.add(translateWord(word));
		}
		return String.join(" ", res);
	}
	
	/**
	a helper method that will take in a String representing a word to be
	translate to Pig Latin	 
	@param word
	@return the single translated word
	*/
	private String translateWord(String word) {
		if (word.equals("")) return word;
		String pre = "";
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (vowels.indexOf(c) == -1) {
				pre += c;
			} else {
				return word.substring(i, word.length()) + pre + "ay";
			}
		}
		return word + "ay";
	}
	
	/**
	Get vowels.
	@return vowels
	*/
	public String getVowels() {
		return vowels;
	}
	
	/**
	Set vowels
	@param val
	*/
	public void setVowels(String val) {
		vowels = val;
	}
}