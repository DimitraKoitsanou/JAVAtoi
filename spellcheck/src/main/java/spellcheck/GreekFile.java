package spellcheck;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GreekFile { // READ FROM TEXT FILE! FILE MUST BE LOCATED INSIDE THE PROJECT!

  private String fileName;

  public GreekFile(String fileName) {
    this.fileName = fileName;
  }

  public void setFileName(String name) {
    this.fileName = name;
  }
  
  public String getFileName(String name) {
	 return fileName;
	  }

  public String readGreekFile() {

    try {
    	
      String text;
      byte[] encoded = Files.readAllBytes(Paths.get(fileName));
      text = new String(encoded,"UTF-8");
      return text;

    } catch (IOException e) {
      System.out.println("Πρόβλημα εισόδου/εξόδου.");
      return null;
    }
  }

}