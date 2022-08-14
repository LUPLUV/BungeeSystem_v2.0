package dev.lupluv.bungee.files;

import java.io.File;
import java.io.IOException;

public class YamlConfiguration {

    public static FileConfiguration loadConfiguration(File file) throws IOException {
        return new FileConfiguration(file);
    }

}
