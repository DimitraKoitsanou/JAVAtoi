public class Menu {

	private String codepage;
	
	public Menu(String codepage) {
		this.codepage = codepage;
		} 

	public String getMenu() {
	
	String userText;
	
	while (true) {
	
			GreekOutput go = new GreekOutput(codepage);
			GreekInput gi = new GreekInput(codepage);	

			
			try {
				go.printLine("��� �� �������� ������� ��� �� ������������ ������� '1'");
				go.printLine("��� �� �������� ������� ��� ������ ������� '2'");
				choice = gi.readLine();
				if ( ! choice.equals("1") || ! choice.equals("2") )
					throw new Exception();
					break;
				} catch(Exception ex) {
				go.printLine("��� ������ ������ �������.");
				}
			}
			
			if ( choice == "1" ) {
				go.printLine("�������������� �� ������� ���: ");
				userText = gi.readLine();
			}
			
			else {
				go.printLine("�������� �� path ��� �������: ");
				String path = gi.readLine();
				GreekFile gf = new GreekFile(path);
				userText = gf.readGreekFile();
			}

	}
	