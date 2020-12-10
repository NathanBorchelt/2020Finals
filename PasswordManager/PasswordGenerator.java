
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator{
  Scanner in=new Scanner(System.in);
  System.out.println("what should the passwords length be");
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = LOWERCASE.toUpperCase();
    private static final String DIGIT = "0123456789";
    private static final String OTHER_SYMBOLS = "!@#&()–[{}]:;',?/*~$^+=<>";

    private static final String PASSWORD =
            LOWERCASE + UPPERCASE + DIGIT + OTHER_SYMBOLS;

    private static SecureRandom random = new SecureRandom();

    public static String createPassword(byte numLets) {

        StringBuilder result = new StringBuilder(numLets);

        // at least 2 characters (lowercase)
        String LowerCase = generateRandomString(LOWERCASE, 2);
        result.append(LowerCase);

        // at least 2 characters
        String UppercaseCaseing = generateRandomString(UPPERCASE, 1);
        result.append(UppercaseCaseing);

        // at least 2 numbers
        String Digit = generateRandomString(DIGIT, 2);
        result.append(Digit);

        // at least 2 special characters (punctuation + symbols)
        String SpecialCharacters = generateRandomString(OTHER_SYMBOLS, 2);
        result.append(SpecialCharacters);

        String password = result.toString();
      
        System.out.println(password);
        return password;
    }

    // generates random characters from the list of characters
    private static String generateRandomString(String input, int size) {

        if (input == null || input.length() <= 0)
            throw new IllegalArgumentException("Invalid input.");
        if (size < 1) throw new IllegalArgumentException("need at least one character");
//puts all the characters into one output
        StringBuilder result = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            // produce a random order
            int index = random.nextInt(input.length());
            result.append(input.charAt(random.nextInt(index)));
        }
        return result.toString();
        }

}