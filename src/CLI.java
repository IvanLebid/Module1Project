import java.util.Scanner;

public class CLI {
    public static void runCLI() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть команду (ENCRYPT, DECRYPT, BRUTE_FORCE): ");
        String command = scanner.nextLine();

        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();
        int key = 0;
        if (command.equalsIgnoreCase("ENCRYPT") || command.equalsIgnoreCase("DECRYPT")) {
            System.out.print("Введіть ключ шифру: ");
            key = scanner.nextInt();
        }

        Runner.run(command, filePath, key);

        scanner.close();
    }
}
