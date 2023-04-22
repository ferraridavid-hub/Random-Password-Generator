package security;

public class Security_Evaluator {
  private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
  private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String DIGITS = "0123456789";
  private static final String SYMBOLS = "~`!@#$^&*()_-+={[]}|\\:;\"'<>,.?/";

  public Security_Evaluator() {
  }

  public int getSecurityValue(String password) {
    boolean isSymbol = false;
    boolean isLowerCase = false;
    boolean isUpperCase = false;
    boolean isDigit = false;
    int value = 0;

    for (int i = 0; i < password.length(); i++) {
      if (LOWER_CASE.indexOf(password.charAt(i)) >= 0)
        isLowerCase = true;
      else if (UPPER_CASE.indexOf(password.charAt(i)) >= 0)
        isUpperCase = true;
      else if (DIGITS.indexOf(password.charAt(i)) >= 0)
        isDigit = true;
      else
        isSymbol = true;

      if (isSymbol && isLowerCase && isUpperCase && isDigit)
        break;
    }

    if (password.length() >= 8)
      value+=4;
    if (password.length() >= 16)
      value+=4;
    if (password.length() >= 24)
      value+=4;
    if (isSymbol)
      value++;
    if (isLowerCase)
      value++;
    if (isUpperCase)
      value++;
    if (isDigit)
      value++;

    return value;
  }
}
