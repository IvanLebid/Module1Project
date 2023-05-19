import java.util.ArrayList;

public class CaesarCipher {
    static ArrayList<Character> myAlphabet = Alphabet.ALPHABET;

    static String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (char symbol : text.toCharArray()) {
            if (myAlphabet.contains(symbol)) {
                int oldIndex = myAlphabet.indexOf(symbol);
                int newIndex = (oldIndex + key) % myAlphabet.size();
                encryptedText.append(myAlphabet.get(newIndex));
            } else {
                encryptedText.append(symbol);
            }
        }

        return encryptedText.toString();
    }

    static String decrypt(String text, int key) {
        StringBuilder decryptedText = new StringBuilder();

        for (char symbol : text.toCharArray()) {
            if (myAlphabet.contains(symbol)) {
                int oldIndex = myAlphabet.indexOf(symbol);
                int newIndex = (oldIndex - key + myAlphabet.size()) % myAlphabet.size();
                if (newIndex < 0) {
                    newIndex = myAlphabet.size() + newIndex;
                }

                decryptedText.append(myAlphabet.get(newIndex));
            } else {
                decryptedText.append(symbol);
            }
//                decryptedText.append(myAlphabet.get(newIndex));
//            } else {
//                decryptedText.append(symbol);
//            }
        }


        return decryptedText.toString();
    }

    static void bruteForceDecrypt(String text) {

        System.out.println("Можливі розшифровки тексту:");
        for (int key = 1; key <= 26; key++) {
            String decryptedText = decrypt(text, key);


            if (decryptedText.toLowerCase().contains("the") && decryptedText.toLowerCase().contains("of")) {
                System.out.println("Ключ:  " + key + "\nРозшифрований текст:\n" + decryptedText);
                break;
            }
        }
    }

}


