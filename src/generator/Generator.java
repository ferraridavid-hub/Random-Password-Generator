package generator;

import java.util.random.RandomGenerator;

public class Generator {
  private String alphabet;
  private RandomGenerator generator = RandomGenerator.of("L64X128MixRandom");
  private StringBuffer sb = new StringBuffer("");

  public Generator(Alphabet a) throws InvalidInputException {
    alphabet = a.getAlphabet();
    if (alphabet.length() == 0)
      throw new InvalidInputException("Cannot generate password without characters");
  }

  public String getPassword(int length) {
    for (int i = 0; i < length; i++) {
      int j = generator.nextInt(alphabet.length());
      sb.append(alphabet.charAt(j));
    }
    return sb.toString();
  }
}