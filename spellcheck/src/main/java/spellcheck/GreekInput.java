package spellcheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class GreekInput { 

  private String codepage;

  public GreekInput(String codepage) {
    this.codepage = codepage;
  }
  
  public void setCodePage(String codepage) {
    this.codepage =  codepage;
  }
  
  public String getCodePage() {
    return codepage;
  }

  /**My <b>class</b>.*/
  public String readLine() {
    try {
      Reader reader = new InputStreamReader(System.in, codepage);
      BufferedReader br = new BufferedReader(reader);
      return br.readLine();
    } catch (UnsupportedEncodingException e) {
      System.out.println(e.toString());
      System.out.println(codepage + "δεν υποστηρίζεται!");
      System.out.println("Τερματισμός προγράμματος!");
      System.exit(0);
      return "";
    } catch (IOException e) {
      System.out.println(e.toString());
      return "";
    }


  }
}
