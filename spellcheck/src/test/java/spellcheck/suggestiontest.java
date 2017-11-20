package spellcheck;

import static org.junit.Assert.*;

import org.junit.Test;

public class suggestiontest {

	@Test
	public void test() {
		Suggestion test = new Suggestion() ;
		String output = test.suggest("άβαθι") ;
		assertEquals("άβαθα",output);
	}

}
