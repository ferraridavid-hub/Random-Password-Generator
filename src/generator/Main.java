package generator;

public class Main {
  public static void main(String[] args) {
    try {
      new Terminal_Interface();
    } catch (InvalidInputException e) {
      System.out.println(e.getMessage());
    }
  }
}