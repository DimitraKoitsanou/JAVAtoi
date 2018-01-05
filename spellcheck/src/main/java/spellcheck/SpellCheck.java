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

    GreekOutput.setCodepage(codepage);
    GreekInput.setCodepage(codepage);
    final String DICTIONARY_FILE = "GreekDictionaryFinal.txt";
    Dictionary d = new Dictionary(DICTIONARY_FILE);
    d.putDictionaryToList();
    HashSet<String> dictionary = d.returnDictionaryList();
    Menu menu = new Menu();
    String userText = menu.getMenu1();

    if (userText == null || userText.isEmpty()) {
<<<<<<< HEAD
      go.printLine("Δεν δώσατε καθόλου κείμενο.");
    } else {
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
          for (String temp2 : suggestions) {
            go.printLine(temp2);
          }
        }
      }
    }
=======

      GreekOutput.printLine("Δεν δώσατε καθόλου κείμενο.");

    } else {

      SplitWords sw = new SplitWords(userText);
      LinkedList<String> splittedWords = sw.getSplittedWordsList();
      CheckWord cw = new CheckWord(dictionary, splittedWords);
      LinkedList<String> NonExistingWords = cw.printNotExistedWords();
    
      if (! NonExistingWords.isEmpty()) {

        String choice = menu.getMenu2();

        if (choice.equals("1")) {

          Suggestion s = new Suggestion(dictionary);

          for (String temp : NonExistingWords) {
            LinkedList<String> suggestions = s.suggest(temp);
            GreekOutput.printLine("Προτάσεις για '" + temp + "': ");
            for (String temp2 : suggestions) {
              GreekOutput.printLine(temp2);
            }
          }
        }
      }  else {
        GreekOutput.printLine("Ο διορθωτής δεν εντόπισε ορθογραφικά λάθη.");
      }
    }
    menu.getMenu3();
>>>>>>> 360352b3a588d834b441c4a276dfb5bf38c5aeea
  }
}