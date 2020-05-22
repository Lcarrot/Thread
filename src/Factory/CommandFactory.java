package Factory;

import Commands.*;

public class CommandFactory {

    public static Command returnCommand(String commandString) {
        Command command = null;
        switch (commandString) {
            case "download":
                command = new DownloadCommand();
                break;
            case "percent":
                command = new PercentCommand();
                break;
            case "interrupt":
                command = new InterruptCommand();
                break;
            case "help":
                command = new HelpCommand();
            default:
                System.out.println("Unknown command");
        }
        return command;
    }
}
