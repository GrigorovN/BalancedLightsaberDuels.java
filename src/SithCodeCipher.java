import java.util.Scanner;

public class SithCodeCipher {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String s =scanner.nextLine();
        int n = scanner.nextInt();

        System.out.println(encryptingSithCode(s, n));;

    }

    public static String encryptingSithCode (String message, int n){

        StringBuilder result = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char firstAlphabeticChar = Character.isLowerCase(character) ? 'a' : 'A';
                char letter = (char) (firstAlphabeticChar + (character - firstAlphabeticChar - n + 26) % 26);
                result.append(letter);
            }
            else {
                result.append(character);
            }
        }

        return result.toString();
    }
}
