package spellcheck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class GreekFile {

  public final String Utf8_Bom = "\uFEFF";
  private String path;

  public GreekFile(String path) {
    this.path = path;
  }

  public void setPath(String path) {
    this.path = path;
  }
  
  public String getPath() {
    return path;
  }

  public String readGreekFile() {

    try {

      String text;
      byte[] encoded = Files.readAllBytes(Paths.get(path));
      text = new String(encoded,"UTF-8");
      text = removeUtf8Bom(text);
      return text;

    } catch (IOException e) {
      System.out.println("Πρόβλημα εισόδου/εξόδου.");
      return null;
    }
  }

  public String removeUtf8Bom(String s) {
    if (s.startsWith(Utf8_Bom)) {
      s = s.substring(1);
    }
    return s;
  }

}