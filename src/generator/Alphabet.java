package generator;

public class Alphabet {
  private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
  private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String DIGITS = "0123456789";
  private static final String SYMBOLS = "~`!@#$^&*()_-+={[]}|\\:;\"'<>,.?/";

  private StringBuilder alph = new StringBuilder();

  Alphabet(boolean lowercase, boolean uppercase, boolean numbers, boolean specialChar) {
    if (lowercase)
      alph.append(LOWER_CASE);

    if (uppercase)
      alph.append(UPPER_CASE);

    if (numbers)
      alph.append(DIGITS);

    if (specialChar)
      alph.append(SYMBOLS);
  }

  public String getAlphabet() {
    return alph.toString();
  }

}