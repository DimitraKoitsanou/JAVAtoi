package spellcheck;
import java.util.LinkedList;

public class CheckWord {
	private LinkedList<String> dictionary;
	private LinkedList<String> userText;


	public CheckWord(LinkedList<String> dictionary, LinkedList<String> userText) {

		this.dictionary = dictionary;
		this.userText = userText;
	}

	public Boolean compareLists(LinkedList<String> dictionary, LinkedList<String> userText) {
		Boolean exitCode = null;
		for (String userWord : userText) {
			if (dictionary.contains(userWord)) {
				exitCode = true;
			} else {
				exitCode = false;
			}
		}
		return exitCode;
	}
}
