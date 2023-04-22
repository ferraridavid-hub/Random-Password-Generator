package generator;

import java.util.Scanner;

import security.Security_Evaluator;

public class Terminal_Interface {

  public Terminal_Interface() throws InvalidInputException {
    boolean lowercase = false;
    boolean uppercase = false;
    boolean numbers = false;
    boolean symbols = false;
    int length = 0;

    // greetings
    System.out.println("""

        ******************************************
        ***  WELCOME TO THE PASSWORD GENERATOR ***
        ******************************************
          """);

    // set user preferences
    try (var scanner = new Scanner(System.in)) {

      System.out.println("Do you want lowercase letters?(y\\n)");
      lowercase = parseAns(scanner.nextLine());

      System.out.println("Do you want uppercase letters?(y\\n)");
      uppercase = parseAns(scanner.nextLine());

      System.out.println("Do you want digits?(y\\n)");
      numbers = parseAns(scanner.nextLine());

      System.out.println("Do you want symbols?(y\\n)");
      symbols = parseAns(scanner.nextLine());

      System.out.println("How many characters do you need?");
      length = scanner.nextInt();

    }

    // generate password
    var alphabet = new Alphabet(lowercase, uppercase, numbers, symbols);
    var psswdGenerator = new Generator(alphabet);
    var password = psswdGenerator.getPassword(length);

    // evaluate security
    var secEval = new Security_Evaluator();
    int security = secEval.getSecurityValue(password);

    System.out.println("\n");
    System.out.println("Generated password: " + password);
    printSecurity(security);
  }

  private void printSecurity(int sec) {
    if (0 <= sec && sec <= 4)
      System.out.println("The password is too weak");
    else if (4 < sec && sec <= 9)
      System.out.println("The password is weak");
    else if (sec == 10)
      System.out.println("The password is acceptable");
    else if (sec == 11)
      System.out.println("The password is strong");
    else
      System.out.println("The password is secure");
  }

  private boolean parseAns(String ans) throws InvalidInputException {
    switch (ans) {
      case "yes":
      case "y":
        return true;
      case "no":
      case "n":
        return false;
      default:
        throw new InvalidInputException("Invalid option: " + ans);
    }
  }
}