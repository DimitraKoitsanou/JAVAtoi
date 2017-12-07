package spellcheck;

import java.util.*;


public class Suggestion {
  private HashSet<String> dictionary;


  public  Suggestion(HashSet<String> dictionary) {

    this.dictionary = dictionary;

  }

  public Suggestion(){

  }

  public void setDictionary(HashSet<String> dictionary) {

    this.dictionary = dictionary;
  }


  public HashSet<String> getDictionary() {
    return dictionary;
  }

  public String suggest(String wrongWord) {

  String suggestion = "καμία πρόταση";
  int minDistance= 50; //Integer.MAX_VALUE; to 50 einai arketo gia tin periptosi mas
  for(String dictionaryWord : dictionary) {
    int distance = 0;
    if ( (Math.abs(wrongWord.length() - dictionaryWord.length()) <= 2 ) &&(dictionaryWord.charAt(0) == wrongWord.charAt(0) )) {
      distance = minimumEditDistance(dictionaryWord,wrongWord);
      if (distance == 1) {
        return dictionaryWord;
      }

				   if (distance < minDistance) {

					minDistance = distance;
					suggestion = dictionaryWord;}

				}

				}


			return suggestion;

		}

		public  int minimumEditDistance(String firstWord, String secondWord) {

		int i, j=0;
		int a = firstWord.length();
		int b = secondWord.length();

		int [][] array = new int[a+1][b+1];

		for (i = 0 ; i <= a ; i++) {

			for (j = 0 ; j <= b ; j++) {

				if (i == 0)
					array[i][j] = j;

				else if (j == 0)
					array[i][j] = i;

				else if (firstWord.charAt(i - 1) == secondWord.charAt(j - 1))
					array[i][j] = array[i - 1][j - 1];

				else
					array[i][j] = 1 + minimum(array[i][j - 1], array[i - 1][j - 1], array[i - 1][j]);

			}


		}

		return array[a][b];

	}

	public int minimum(int num1, int num2, int num3) {

		int min1 = (num1 <= num2) ? num1 : num2 ;

		return ( ( min1 <= num3 ) ? min1 : num3 );

	}

}