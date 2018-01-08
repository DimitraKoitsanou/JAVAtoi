package spellcheck;

public class Menu {

  public Menu() {

  }

  public String getMenu1() {

    String userText;
    String choice;

    while (true) {

      try {

        GreekOutput.printLine("=== ΔΙΟΡΘΩΤΗΣ ΕΛΛΗΝΙΚΟΥ ΚΕΙΜΕΝΟΥ ===");
        GreekOutput.printLine("Για να εισάγετε κείμενο:");
        GreekOutput.printLine("-από πληκτρολόγιο πατήστε '1'");
        GreekOutput.printLine("-από κάποιο αρχείο πατήστε '2'");
        choice = GreekInput.readLine();

        if (! (choice.equals("1") || choice.equals("2"))) {
          throw new Exception();
        }

        break;

      } catch (Exception ex) {
        GreekOutput.printLine("Δεν εισάγατε έγκυρη επιλογή. Ξαναπροσπαθήστε.");
        GreekOutput.printLine("");
      }
    }

    if (choice.equals("1")) {
    
      GreekOutput.printLine("Πληκτρολογήστε το κείμενό σας: ");
      GreekOutput.printLine("");
      userText = GreekInput.readLine();

    } else {

      while (true) {

        GreekOutput.printLine("Εισάγετε το path του αρχείου: ");
        String path = GreekInput.readLine();
        GreekFile gf = new GreekFile(path);
        userText = gf.readGreekFile();
        if (! userText.equals("-1")) {
          break;
        }
      }
    }
    return userText;
  }

  public String getMenu2() {

    GreekOutput.printLine("");
    GreekOutput.printLine("-Αν θέλετε να σας γίνουν προτάσεις πατήστε '1'");
    GreekOutput.printLine("-Αν δεν θέλετε να σας γίνουν προτάσεις πατήστε οτιδήποτε άλλο:");
    String choice = GreekInput.readLine();
    return choice;

  }

  public void getMenu3() {

    GreekOutput.printLine("");
    GreekOutput.printLine("Ευχαριστούμε που χρησιμοποιήσατε την εφαρμογή μας.");
    GreekOutput.printLine("Ομάδα υλοποίησης: Javatoi " + "\u00a9");

  }
}