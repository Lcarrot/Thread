package Commands;

import java.util.Scanner;
import Utils.*;

public class InterruptCommand extends Command{

    @Override
    public void execute(Scanner scanner) {
        System.out.println("Write a download name");
        String name = scanner.next();
        if (Downloads.deleteThread(name)) {
            System.out.println("Downloads was successfully removed");
        }
        else {
            System.out.println("This download is't execute");
        }
    }
}
