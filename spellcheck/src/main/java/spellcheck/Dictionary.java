package spellcheck;

import java.io.*;
import java.util.LinkedList;
import java.io.BufferedReader;

public class Dictionary {
	
	private LinkedList<String> dictionary  = new LinkedList<String>();
	private String fileName;
	
	public Dictionary(String fileName) {
		this.fileName = fileName;
	}

	String line = null;

	GreekOutput greekOutput = new GreekOutput();

	public LinkedList<String> addDictionaryToList() {

		try { // Read words from text file and store them in dictionary list

			File fileDir = new File(fileName);

			BufferedReader in = new BufferedReader(
			   new InputStreamReader(
	                      new FileInputStream(fileDir), "Cp1253"));

			while( (line = in.readLine() ) != null )  // Until every line has been read
				dictionary.add(line); // Add every word from Dictionary to the List
			in.close();

	} catch (FileNotFoundException ex) {
		greekOutput.printText("Δεν βρέθηκε το αρχείο.");
	} catch (IOException ex) {
		greekOutput.printText("Πρόβλημα στην ανάγνωση αρχείου.");

	}	
		return dictionary;
	}

}
