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
	private String codePage;
	
	public Dictionary(String fileName , String codePage) {
		this.fileName = fileName;
		this.codePage = codePage;
	}
	
	public HashSet<String> returnDictionaryList(HashSet<String> dictionary){
		return dictionary;
	}

	public void putDictionaryToList() {
		GreekOutput greekOutput = new GreekOutput(codePage);
		BufferedReader br = null;

	try {
			
		FileInputStream fis = new FileInputStream(fileName);
		br = new  BufferedReader(new InputStreamReader(fis,"UTF-8"));
		String line = null;
		while( (line = br.readLine() ) != null )
				dictionary.add(line); 
		
	} catch (FileNotFoundException ex) {
		greekOutput.printLine("Δεν βρέθηκε το αρχείο.");
	} catch (IOException ex) {
		System.out.println(ex.toString());
		greekOutput.printLine("Τερματισμός Προγράμματος.");
		System.exit(0);

	} finally {
		try {
			if (br != null)
				br.close();
		} catch (IOException ex ) {
			System.out.println(ex.toString());
		}
	}	
	}
	

}