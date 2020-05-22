package Utils;

import java.util.HashMap;
import java.util.Map;

public class Downloads {
    private static Map<String, DownloadThread> downloads = new HashMap<>();

    public static boolean addThread(String name, DownloadThread thread) {
        if(!downloads.containsKey(name)) {
            downloads.put(name, thread);
            return true;
        }
        return false;
    }

    public static boolean deleteThread(String name) {
        if(downloads.containsKey(name)) {
            DownloadThread thread = downloads.remove(name);
            thread.interrupt();
            return true;
        }
        return false;
    }

    public static DownloadThread takeThread(String name) {
        if (downloads.containsKey(name)) {
            return downloads.get(name);
        }
        return null;
    }

}
