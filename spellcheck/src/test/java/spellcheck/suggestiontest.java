package spellcheck;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class suggestiontest {

	@Test
	public void test() {
		
		Dictionary d = new Dictionary("GreekDictionaryFinal.txt");
	    d.putDictionaryToList();
		HashSet<String> dictionary = d.returnDictionaryList();
		Suggestion test = new Suggestion(dictionary) ;
	
		String output = test.suggest("σπίιτι") ;
		assertEquals("σπίτι",output);
		
		int med = test.minimumEditDistance("σπίτι", "σπιτια");
		assertEquals(med,2);
		
	}

}
