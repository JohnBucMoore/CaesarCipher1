public class WordPlay {

    public boolean isVowel(char ch) {
        String vowels = "aeiou";
        if (vowels.indexOf(Character.toLowerCase(ch)) != -1) {
            return true;
        }
        return false;
    }

    public String replaceVowels(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            char currChar = phrase.charAt(i);
            if (isVowel(currChar)) {
                if (Character.isUpperCase(currChar)) {
                    newPhrase.setCharAt(i, Character.toUpperCase(ch));
                } else {
                    newPhrase.setCharAt(i, Character.toLowerCase(ch));
                }
            }
        }
        return newPhrase.toString();
    }
/*
    public void digitTest() {
        String test = "ABCabc0123456789';#!";
        for (int k=0; k < test.length(); k++) {
            char ch = test.charAt(k);
            if (Character.isDigit(ch)) {
                System.out.println(ch+" is a digit");
            }
            if (Character.isAlphabetic(ch)) {
                System.out.println(ch+" is alphabetic");
            }
        }
    }

    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0, key);
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
*/
    public void testIsVowel() {
        System.out.println(isVowel('F'));
        System.out.println(isVowel('g'));
        System.out.println(isVowel('A'));
        System.out.println(isVowel('!'));
        System.out.println(isVowel('u'));
        System.out.println(isVowel('9'));
    }

    public void testReplaceVowels() {
        System.out.println(replaceVowels("Aloha", 'x'));
    }

    public static void main(String[] args) {
        WordPlay string = new WordPlay();
        //string.digitTest();
        //System.out.println(string.encrypt("Hello World!", 13));
        //string.testIsVowel();
        string.testReplaceVowels();
    }
}
