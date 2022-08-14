package dev.lupluv.bungee.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.apache.commons.io.IOUtils.DEFAULT_BUFFER_SIZE;

public class FileManager {

    public static final String dirName = "plugins//BungeeSystem//";

    public void loadFiles() throws IOException {
        File folder = new File("plugins//BungeeSystem");
        if(!folder.exists()) folder.mkdir();
        copyResourceFile("config.yml", "config.yml");
        copyResourceFile("mysql.yml", "mysql.yml");
        copyResourceFile("messages.yml", "messages.yml");
    }

    public File getMysqlFile(){
        return new File(dirName + "mysql.yml");
    }

    public FileConfiguration getMysql(){
        if(getMysqlFile().exists()){
            try {
                return YamlConfiguration.loadConfiguration(getMysqlFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void copyResourceFile(String src, String dest) throws IOException {
        InputStream resourceURL = this.getClass().getResourceAsStream("/spigot/" + src);

        File file2 = new File(dirName + dest);

        copyInputStreamToFile(resourceURL, file2);

    }

    private static void copyInputStreamToFile(InputStream inputStream, File file)
            throws IOException {

        // append = false
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }

    }

}
