package spellcheck;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GreekInput {
	private String codepage;
	
	public GreekInput(String codepage){
		this.codepage = codepage;
	}
	
	public String readLine() throws IOException{
		 Reader reader = new InputStreamReader(System.in, codepage );
		 BufferedReader br = new BufferedReader(reader);
		 return br.readLine();
	 }
}
