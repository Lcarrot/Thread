import Commands.Command;
import Factory.CommandFactory;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String commandString = scanner.next();
        while (!commandString.equals("exit")) {
            Command command = CommandFactory.returnCommand(commandString);
            command.execute(scanner);
            commandString = scanner.next();
        }
    }
}
