package dev.lupluv.spigot;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.FileUtil;

import java.io.File;
import java.io.IOException;

public class SpigotMain extends JavaPlugin {

    private static SpigotMain spigotMain;

    @Override
    public void onEnable() {
        spigotMain = this;
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

    }

    public static SpigotMain getSpigotMain() {
        return spigotMain;
    }

    public static void main(String[] args) throws IOException {
        File file = new File(".//resources//config.yml");
        File file2 = new File("E:\\config.yml");
        if(!file2.exists()) file2.createNewFile();
        FileUtil.copy(file, file2);
    }

}
