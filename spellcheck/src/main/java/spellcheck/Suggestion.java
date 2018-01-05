package spellcheck;

import java.util.*;


public class Suggestion {

  private HashSet<String> dictionary;

  public  Suggestion(HashSet<String> dictionary) {
    this.dictionary = dictionary;
  }

  public void setDictionary(HashSet<String> dictionary) {
    this.dictionary = dictionary;
  }


  public HashSet<String> getDictionary() {
    return dictionary;
  }

  public LinkedList<String> suggest(String wrongWord) {

    LinkedList<String> suggestions = new LinkedList<String>();
    
    if (wrongWord.length() <= 2) {
<<<<<<< HEAD
      suggestions.add("Η λέξη είναι πολύ μικρή για να γίνουν προστάσεις");
      return suggestions;
    }
    
=======
      suggestions.add("Η λέξη είναι πολύ μικρή για να γίνουν προτάσεις");
      return suggestions;
    }

>>>>>>> 360352b3a588d834b441c4a276dfb5bf38c5aeea
    int counter = 0;
    String suggestion = "";

    int minDistance = Integer.MAX_VALUE;

    for (String dictionaryWord : dictionary) {
<<<<<<< HEAD
      int distance = 0;
      if (Math.abs(wrongWord.length() - dictionaryWord.length()) <= 2) {
        distance = minimumEditDistance(dictionaryWord,wrongWord);
=======

      int distance = 0;

      if (Math.abs(wrongWord.length() - dictionaryWord.length()) <= 2) {

        distance = minimumEditDistance(dictionaryWord,wrongWord);

>>>>>>> 360352b3a588d834b441c4a276dfb5bf38c5aeea
        if (distance == 1 && counter <= 4 && dictionaryWord.length() >= 3) {
          suggestions.add(dictionaryWord);
          counter++;
        }
<<<<<<< HEAD
        if (distance < minDistance) {
=======

        if (distance < minDistance) {

>>>>>>> 360352b3a588d834b441c4a276dfb5bf38c5aeea
          minDistance = distance;
          suggestion = dictionaryWord;
        }

      }
    }
    
    if (! suggestions.contains(suggestion)) {
      suggestions.add(suggestion);
<<<<<<< HEAD
      return suggestions;
    }
  }

  public int minimumEditDistance(String firstWord, String secondWord) {
=======
    }
    return suggestions;
  }

  public int minimumEditDistance(String firstWord, String secondWord) {

>>>>>>> 360352b3a588d834b441c4a276dfb5bf38c5aeea
    int i = 0;
    int j = 0;
    int a = firstWord.length();
    int b = secondWord.length();
<<<<<<< HEAD
    int [][] array = new int[a + 1][b + 1];
    for (i = 0 ; i <= a ; i++) {
      for (j = 0 ; j <= b ; j++) {
=======

    int [][] array = new int[a + 1][b + 1];

    for (i = 0 ; i <= a ; i++) {

      for (j = 0 ; j <= b ; j++) {

>>>>>>> 360352b3a588d834b441c4a276dfb5bf38c5aeea
        if (i == 0) {
          array[i][j] = j;
        } else if (j == 0) {
          array[i][j] = i;
        } else if (firstWord.charAt(i - 1) == secondWord.charAt(j - 1)) {
          array[i][j] = array[i - 1][j - 1];
        } else {
          array[i][j] = 1 + minimum(array[i][j - 1], array[i - 1][j - 1], array[i - 1][j]);
        }
<<<<<<< HEAD
      }
    }
    return array[a][b];

  }

  public int minimum(int num1, int num2, int num3) {
    int min1 = (num1 <= num2) ? num1 : num2 ;
    return ((min1 <= num3) ? min1 : num3);
  }
=======

      }
    }

    return array[a][b];
  }

  public int minimum(int num1, int num2, int num3) {

    int min1 = (num1 <= num2) ? num1 : num2 ;

    return ((min1 <= num3) ? min1 : num3);
>>>>>>> 360352b3a588d834b441c4a276dfb5bf38c5aeea

  }
}