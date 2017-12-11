package spellcheck;

import static org.junit.Assert.*;
import java.util.HashSet;


import org.junit.Test;

public class DictionaryTest {
	
	@Test
	public void Dictionarytest() {
		HashSet<String> list = new HashSet<String>();
		String a = "καλή" ;
		String b = "αγαπάω";
		String c = "υπαρκτά";
		list.add(a);
		list.add(b);
		list.add(c);
		System.out.println(list);
		Dictionary dictionary = new Dictionary("GreekDictionaryFinal.txt", "UTF-8");
		dictionary.putDictionaryToList();
		HashSet<String> lexiko = dictionary.returnDictionaryList();
		
		int counter = 0;
		for (int i = 0 ; i < list.size() ; i++) {
		
		if (lexiko.containsAll(list)) {
			counter++;
		}
		}
		
		int expected = 3;
		assertEquals(expected, counter);
		
		
		
		
		
		
		
		
	}

}
