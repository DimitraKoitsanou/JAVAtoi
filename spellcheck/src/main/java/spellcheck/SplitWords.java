package spellcheck;

import java.util.LinkedList;

public class SplitWords {

  private String text;

  public SplitWords(String text) {
    this.text = text;
  }

  public void setText(String text) {
    this.text = text;
  }
  
  public String getText() {
    return text;
  }

  public  LinkedList<String> getSplittedWordsList() {

    LinkedList<String> splittedWords = new LinkedList<String>();
    String [] splitted = text.toLowerCase().replaceAll("\\p{Punct}", "")
      .replaceAll("[0-9]","").replaceAll("[a-zA-Z]","")
      .replaceAll("\\s+"," ").split("\\s+"); 
    for (String temp : splitted) {
      splittedWords.add(temp);
    }
    return splittedWords;
  }

}

