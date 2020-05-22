package Utils;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class DownloadThread extends Thread {
    private final URL url;
    private final Path fileTo;
    private final int BUFFER_SIZE = 1024;
    private final String name;

    public DownloadThread(Path fileTo, URL url, String name) {
        this.url = url;
        this.fileTo = fileTo;
        this.name = name;
    }

    @Override
    public void run() {
        try (BufferedInputStream reader = new BufferedInputStream(url.openConnection().getInputStream());
             FileOutputStream writer = new FileOutputStream(String.valueOf(fileTo))) {
            byte[] byteBuffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = reader.read(byteBuffer, 0, BUFFER_SIZE)) != -1) {
                if (!isInterrupted()) {
                    writer.write(byteBuffer,0, bytesRead);
                    Thread.sleep(50);
                }
                else throw new InterruptedException();
            }
            System.out.println(name + "file has been successfully downloaded");
        } catch (InterruptedException e) {
            try {
                Files.delete(fileTo);
                System.out.println("File was successfully deleted");
            } catch (IOException ioException) {
                System.out.println("Can't delete a file that wasn't fully downloaded");
            }
            System.out.println("A download interrupted");
        }catch (FileNotFoundException e){
            System.out.println("Can't record a file with this path, please check the path");
        } catch (IOException e) {
            System.out.println("Can't record this file");
        }
        Downloads.deleteThread(name);
    }
    public long getSizeFromURL() {
        try {
            return url.openConnection().getContentLengthLong();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public long getSizeFromPath() {
        try {
            return  Files.size(fileTo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
