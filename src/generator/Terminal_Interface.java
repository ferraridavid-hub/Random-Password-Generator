package generator;

import java.util.Scanner;

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
    var psswdGenerator = new Generator(alphabet, length);
    System.out.println("Generated password: " + psswdGenerator.getPassword());
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