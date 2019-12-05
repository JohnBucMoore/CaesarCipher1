import edu.duke.FileResource;

public class CaesarCipher {

    public String encrypt(String input, int key) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newAlpha = alpha.substring(key)+alpha.substring(0,key);
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            int cipherCharIndex = alpha.indexOf(currChar);
            if (currChar == ' ') {
                output.setCharAt(i,' ');
            } else {
                char newChar = newAlpha.charAt(cipherCharIndex);
                output.setCharAt(i, newChar);
            }
        }
        return output.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphaKey1 = alpha.substring(key1)+alpha.substring(0,key1);
        String alphaKey2 = alpha.substring(key2)+alpha.substring(0,key2);
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            if (currChar != ' ') {
                if (Character.isUpperCase(currChar)) {
                    int currIndex = alpha.indexOf(currChar);
                    if (i % 2 == 0) {
                        output.setCharAt(i, alphaKey1.charAt(currIndex));
                    } else {
                        output.setCharAt(i, alphaKey2.charAt(currIndex));
                    }
                }
                else {
                    int currIndex = alpha.indexOf(Character.toUpperCase(currChar));
                    if (i % 2 == 0) {
                        output.setCharAt(i, Character.toLowerCase(alphaKey1.charAt(currIndex)));
                    } else {
                        output.setCharAt(i, Character.toLowerCase(alphaKey2.charAt(currIndex)));
                    }
                }
            }
        }
        return output.toString();
    }

    public void test() {
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK", 23));
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 23;
        String encrypted = encrypt(message, key);
        System.out.println("key is "+ key + "\n" + encrypted);
    }

    public void testEncryptTwoKeys() {
        System.out.println(encryptTwoKeys("First Legion", 23, 17));
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher();
        cipher.testEncryptTwoKeys();
    }
}
