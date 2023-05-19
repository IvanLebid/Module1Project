import java.io.IOException;

public class Runner {
    public static void havingArguments(String[] args){
            String command = args[0];
            String filePath = args[1];
            int key = 0;
            if (command.equalsIgnoreCase("ENCRYPT") || command.equalsIgnoreCase("DECRYPT")) {
                key = Integer.parseInt(args[2]);
            }
            run(command, filePath, key);

    }

    public static void run(String command, String filePath, int key) {

        try {
            String text = FileService.fileReader(filePath);

            if (command.equalsIgnoreCase("ENCRYPT")) {
                String encryptedText = CaesarCipher.encrypt(text, key);
                FileService.fileSaver(encryptedText, "[ENCRYPTED]", filePath);
            } else if (command.equalsIgnoreCase("DECRYPT")) {
                String decryptedText = CaesarCipher.decrypt(text, key);
                FileService.fileSaver(decryptedText, "[DECRYPTED]", filePath);
            } else if (command.equalsIgnoreCase("BRUTE_FORCE")) {
                CaesarCipher.bruteForceDecrypt(text);

            } else {
                System.out.println("Невідома команда");
            }
        } catch (IOException e) {
            System.out.println("Помилка при читанні або запису файлу: " + e.getMessage());
        }

    }
}

