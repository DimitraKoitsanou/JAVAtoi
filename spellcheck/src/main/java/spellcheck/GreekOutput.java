package spellcheck;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class GreekOutput {

  private String codepage;
 
  public GreekOutput(String codepage) {
    this.codepage = codepage;
  }

  public void printLine(String text) {

    try {
      PrintWriter p = new PrintWriter(new OutputStreamWriter(System.out,codepage),true);
      p.println(text);
    } catch (UnsupportedEncodingException e) {
      System.out.println(e.toString());
      System.out.println(codepage + "not supported.");
      System.out.println("Ending program.");
      System.exit(0);
    }
  }
}