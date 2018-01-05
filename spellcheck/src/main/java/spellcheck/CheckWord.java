package spellcheck;

import java.util.HashSet;
import java.util.LinkedList;

public class CheckWord {

  private HashSet<String> dictionary;
  private LinkedList<String> wordsToCheck;

  public CheckWord(HashSet<String> dictionary, LinkedList<String> wordsToCheck) {

    this.dictionary = dictionary;
    this.wordsToCheck = wordsToCheck;

  }

  public void setDictionary(HashSet<String> dictionary) {
    this.dictionary = dictionary;
  }

  public void setWordsToCheck(LinkedList<String> wordsToCheck) {
    this.wordsToCheck = wordsToCheck;
  }

  public LinkedList<String> printNotExistedWords() {

    LinkedList<String> nonExistedWords = new LinkedList<String>();

    for (String temp: wordsToCheck) {
      if (! dictionary.contains(temp)) {
        GreekOutput.printLine("Η λέξη '" + temp + "' δεν υπάρχει στο λεξικό μου.");
        nonExistedWords.add(temp);
      }
    }
    return nonExistedWords;
  }
}