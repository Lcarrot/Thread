package Commands;

import java.util.Scanner;
import Utils.*;

public class PercentCommand extends Command {
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Write a download name");
        String name = scanner.next();
        DownloadThread thread = Downloads.takeThread(name);
        if (thread == null) {
            System.out.println("This download isn't execute");
        }
        else {
            long percent = (long) (((double)thread.getSizeFromPath())/thread.getSizeFromURL()*100);
            System.out.println(percent + "%");
        }
    }
}
