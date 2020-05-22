package Commands;

import Utils.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DownloadCommand extends Command {

    @Override
    public void execute(Scanner scanner) {
        DownloadThread thread;
        try {
            System.out.println("Write a url for downloading");
            URL url = new URL(scanner.next());
            System.out.println("Write a path on computer");
            Path pathTo = Paths.get(scanner.next()).normalize().toAbsolutePath();
            String type = url.openConnection().getContentType();
            String[] types = type.split("[/;]");
            System.out.println("Write a name for downloading");
            String name = scanner.next();
            pathTo = Paths.get(pathTo + File.separator + name + "." + types[1]);
            thread = new DownloadThread(pathTo, url, name);
            if (Downloads.addThread(name,thread)) {
                thread.start();
            }
            else {
                System.out.println("Can't download this file, because download with this name already do");
            }
        } catch (MalformedURLException e) {
            System.out.println("This url isn't right");
        } catch (IOException e) {
            System.out.println("Can't determine a type");
        }
    }
}
