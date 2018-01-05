package spellcheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class GreekInput {

  private static String codepage;

  public static void setCodepage(String cdpage) {
    codepage = cdpage;
  }

  public static String getCodePage() {
    return codepage;
  }

  public static String readLine() {

    try {

      Reader reader = new InputStreamReader(System.in, codepage);
      BufferedReader br = new BufferedReader(reader);
      return br.readLine();

    } catch (UnsupportedEncodingException e) {
      System.out.println(e.toString());
      return "";
    } catch (IOException e) {
      System.out.println(e.toString());
      return "";
    }
  }
}