package spellcheck;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

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
      GreekOutput.printLine("Πρόβλημα εισόδου/εξόδου.");
      return "-1";
    } catch (InvalidPathException ex) {
      System.out.println(ex.toString());
      GreekOutput.printLine("Μη έγκυρος χαρακτήρας.");
      return "-1";
    }
  }

<<<<<<< HEAD
  public String removeUtf8Bom(String s) {
    if (s.startsWith(Utf8_Bom)) {
=======
  public String removeUTF8BOM(String s) {

    if (s.startsWith(UTF8_BOM)) {
>>>>>>> 360352b3a588d834b441c4a276dfb5bf38c5aeea
      s = s.substring(1);
    }
    return s;
  }
}