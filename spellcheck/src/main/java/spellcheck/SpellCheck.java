package spellcheck;

import java.util.HashSet;
import java.util.LinkedList;

public class SpellCheck {

  public static void main(String[] args) {

    String codepage = "";
    try {
      codepage = args[0];
    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.println("No codepage given. Ending program...");
      System.exit(1);
    }

    GreekOutput go = new GreekOutput(codepage);
    GreekInput gi = new GreekInput(codepage);
    Dictionary d = new Dictionary("GreekDictionaryFinal.txt",codepage);
    d.putDictionaryToList();
    HashSet<String> dictionary = d.returnDictionaryList();
    Menu menu = new Menu(codepage);
    String userText = menu.getMenu();

    if (userText == null || userText.isEmpty()) {
    	go.printLine("Δεν δώσατε καθόλου κείμενο.");
    }
    else {

    SplitWords sw = new SplitWords(userText);
    LinkedList<String> splittedWords = sw.getSplittedWordsList();
    CheckWord cw = new CheckWord(dictionary, splittedWords, codepage);
    LinkedList<String> NonExistingWords = cw.printNotExistedWords();
    go.printLine("Αν θέλετε να σας γίνουν προτάσεις πατήστε '1': ");
    String choice = gi.readLine();

    if (choice.equals("1")) {

      Suggestion s = new Suggestion(dictionary);

      for (String temp : NonExistingWords) {
        LinkedList<String> suggestions = s.suggest(temp);
        go.printLine("Προτάσεις για '" + temp + "': ");
        for(String temp2 : suggestions)
        go.printLine(temp2);
      }
    }
   }
  }
}
