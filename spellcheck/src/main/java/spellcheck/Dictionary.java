package spellcheck;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Dictionary {

  private HashSet<String> dictionary  = new HashSet<String>();
  private String fileName;

  public Dictionary(String fileName) {
    this.fileName = fileName;
  }

  public HashSet<String> returnDictionaryList() {
    return dictionary;
  }

  public void putDictionaryToList() {

    BufferedReader br = null;

    try {

      FileInputStream fis = new FileInputStream(fileName);
      br = new  BufferedReader(new InputStreamReader(fis,"UTF-8"));
      String line = null;
      br.readLine();
      while ((line = br.readLine()) != null) {
        dictionary.add(line); 
      }

    } catch (FileNotFoundException ex) {
      GreekOutput.printLine("Δεν βρέθηκε το αρχείο.");
    } catch (IOException ex) {
      System.out.println(ex.toString());
      GreekOutput.printLine("Τερματισμός Προγράμματος.");
      System.exit(0);
    } finally {
      try {

        if (br != null) {
          br.close();
        }

      } catch (IOException ex) {
        System.out.println(ex.toString());
      }
    }
  }
}