package spellcheck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class GreekFile {

  public final String UTF8_BOM = "\uFEFF";
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
      text = removeUTF8BOM(text);
      return text;

    } catch (IOException e) {
      System.out.println("Πρόβλημα εισόδου/εξόδου.");
      return null;
    }
  }

  public String removeUTF8BOM(String s) {
    if (s.startsWith(UTF8_BOM)) {
      s = s.substring(1);
    }
    return s;
  }

}