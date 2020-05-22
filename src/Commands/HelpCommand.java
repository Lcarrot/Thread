package Commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HelpCommand extends Command {

    private final String[] command = new String[]{"download", "percent", "interrupt", "help"};
    private final String[] commandDescription = new String[] {
            "download a file",
            "information about loading",
            "end downloading(file was deleted)",
            "info about commands"
    };

    @Override
    public void execute(Scanner scanner) {
        for (int i = 0; i < command.length; i++) {
            System.out.println(command[i] +" - " + commandDescription[i]);
        }
    }
}
