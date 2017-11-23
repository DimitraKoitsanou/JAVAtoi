package spellcheck;
import java.util.HashSet;
import java.util.LinkedList;

public class CheckWord {
	private HashSet<String> dictionary;
	private LinkedList<String> wordsToCheck;
	private String codepage;

	public CheckWord(HashSet<String> dictionary, LinkedList<String> wordsToCheck, String codepage) {

		this.dictionary = dictionary;
		this.wordsToCheck = wordsToCheck;
		this.codepage = codepage;
	}
	
	public void setDictionary(HashSet<String> dictionary) {
		this.dictionary = dictionary;
	}
	
	public void setWordsToCheck(LinkedList<String> wordsToCheck) {
		this.wordsToCheck = wordsToCheck;
	}

	public void setCodepage(String codepage) {
		this.codepage = codepage;
	}
	
	public LinkedList<String> printNotExistedWords() {
		LinkedList<String> nonExistedWords = new LinkedList<String>();
		GreekOutput go = new GreekOutput(codepage);
		
		for(String temp: wordsToCheck)
			if(! dictionary.contains(temp)) {
				go.printLine("Η λέξη '" + temp + "' δεν υπάρχει στο λεξικό μου.");
				nonExistedWords.add(temp);
		}
		return nonExistedWords;
	}
}
