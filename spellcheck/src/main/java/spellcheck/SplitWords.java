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
    
    String [] splitted = text.trim().replaceAll("[^α-ωΑ-ΩςάέήίόύώΆΈΉΊΌΎΏϊΐϋΰΪΫ. ]","")
            .replaceAll("\\s{2,}", " ").split("\\s+");


    for (String temp : splitted) {
      splittedWords.add(temp);
    }
    
    if (splittedWords.isEmpty()) {
      return splittedWords;

    } else {

      return toLowerCaseAfterFullstop(splittedWords);
    }
  }
  
  public LinkedList<String> toLowerCaseAfterFullstop( LinkedList<String> list) {

    LinkedList<String> splittedWordsNoDots = new LinkedList<String>();

    boolean fullstop = true;

    for (String temp : list) {

      if (fullstop) {

        if (temp.length() > 0) {
          temp = Character.toLowerCase(temp.charAt(0)) + temp.substring(1);
        }
      }

      if (temp.contains(".")) {
        temp = temp.replaceAll(".","");
        fullstop = true;
      } else {
        fullstop = false;
      }

      if (! temp.equals("")) {
        splittedWordsNoDots.add(temp);
      }
    }
    return splittedWordsNoDots;
  }
}