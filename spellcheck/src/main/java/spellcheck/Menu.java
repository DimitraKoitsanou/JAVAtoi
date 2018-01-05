package spellcheck;

public class Menu {

	private String codepage;
	
	public Menu(String codepage) {
		this.codepage = codepage;
		} 

	public String getMenu() {
	
	String userText;
	String choice;
	GreekOutput go = new GreekOutput(codepage);
	GreekInput gi = new GreekInput(codepage);	
	
	while (true) {
		
		try {
			go.printLine("Για να εισάγετε κείμενο από το πληκτρολόγιο πατήστε '1'");
			go.printLine("Για να εισάγετε κείμενο από κάποιο αρχείο πατήστε '2':");
			choice = gi.readLine();
			if ( ! ( choice.equals("1") || choice.equals("2") ) ) {
				throw new Exception();
				break;
			} 
			catch(Exception ex) {
			go.printLine("Δεν εισάγατε έγκυρη επιλογή. Ξαναπροσπαθήστε.");
			}
		}
		
		if ( choice.equals("1") ) {
			go.printLine("Πληκτρολογήστε το κείμενό σας: ");
			userText = gi.readLine();
		}
		
		else {
			go.printLine("Εισάγετε το path του αρχείου: ");
			String path = gi.readLine();
			GreekFile gf = new GreekFile(path);
			userText = gf.readGreekFile();
		}
		return userText;
	}
	}
}