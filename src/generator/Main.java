package generator;

import java.util.InputMismatchException;

public class Main {
  public static void main(String[] args) {
    try {
      new Terminal_Interface();
    } catch (InvalidInputException e) {
      System.out.println(e.getMessage());
    } catch (InputMismatchException e) {
      System.out.println("Please, enter a positive number for the password length");
    }
  }
}