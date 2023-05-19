
public class Main {
    public static void main(String[] args) {

        if (args.length == 2 || args.length == 3) {
            Runner.havingArguments(args);
        } else {
            CLI.runCLI();
        }
    }
}
