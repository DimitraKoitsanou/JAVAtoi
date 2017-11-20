package spellcheck;
import java.util.LinkedList;

public class SplitWords {
	
	private String text;
	
	public SplitWords(String text) {
		this.text = text;
	}

	public  LinkedList<String> getUserWords() {

		String [] userWords = text.replaceAll("\\p{P}", "").toLowerCase().split("\\s+");
		LinkedList<String> userText = new LinkedList<String>();

		for(String word : userWords){
			userText.add(word);
		}
	    return userText;
	}
}
