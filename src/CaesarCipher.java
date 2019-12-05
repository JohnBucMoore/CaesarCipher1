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

    public void test() {
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK", 23));
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher();
        cipher.test();
    }
}
