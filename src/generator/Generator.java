package generator;

import java.util.random.RandomGenerator;

public class Generator {
  private RandomGenerator generator = RandomGenerator.of("L64X128MixRandom");
  private StringBuffer sb = new StringBuffer("");

  public Generator(Alphabet a, int length) throws InvalidInputException {
    String alphabet = a.getAlphabet();
    if (alphabet.length() == 0)
      throw new InvalidInputException("Cannot generate password without characters");

    for (int i = 0; i < length; i++) {
      int j = generator.nextInt(alphabet.length());
      sb.append(alphabet.charAt(j));
    }
  }

  public String getPassword() {
    return sb.toString();
  }
}