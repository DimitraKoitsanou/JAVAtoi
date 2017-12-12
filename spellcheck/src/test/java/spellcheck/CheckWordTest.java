package spellcheck;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;

public class CheckWordTest {


	public void test() {
		
		Dictionary d = new Dictionary("GreekDictionaryFinal.txt");
		d.putDictionaryToList();
		HashSet<String> dictionary = d.returnDictionaryList();
	
		LinkedList<String> testList = new LinkedList();
		testList.add("καλημέερα");
		testList.add("σπίτι");
		
		CheckWord cw = new CheckWord(dictionary, testList, "UTF-8");
		LinkedList<String> output = cw.printNotExistedWords();
		String expected = "καλημέερα";
		assertEquals(expected, output.get(0));
		
	}

}

