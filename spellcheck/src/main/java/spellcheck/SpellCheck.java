package spellcheck;
import java.util.HashSet;
import java.util.LinkedList;

public class SpellCheck {

	public static void main(String[] args) {
		
		String codepage="";
		try {
			codepage = args[0];
		} catch( ArrayIndexOutOfBoundsException ex) {
			System.out.println("No codepage given. Ending program...");
			System.exit(1);
		}
		
		GreekOutput go = new GreekOutput(codepage);
		GreekInput gi = new GreekInput(codepage);
		Dictionary d = new Dictionary("greekWords.txt",codepage);
		d.putDictionaryToList();
		HashSet<String> dictionary = d.returnDictionaryList();
		Menu menu = new Menu(codepage);
		String userText= menu.getMenu();
		
		SplitWords sw = new SplitWords(userText);
		LinkedList<String> splittedWords = sw.getSplittedWordsList();
		CheckWord cw = new CheckWord(dictionary, splittedWords, codepage);
		LinkedList<String> NonExistingWords = cw.printNotExistedWords();
		
		go.printLine("Αν θέλετε να σας γίνουν προτάσεις πατήστε '1': ");
			String choice = gi.readLine();
		
		if( choice.equals("1") ) {
			
			Suggestion s = new Suggestion(dictionary);
			
			for(String temp : NonExistingWords ) {
				String suggestion = s.suggest(temp); // Make it a list!
				go.printLine("Πρόταση για '" + temp + "': " + suggestion);
			}	
		}
	}
}
