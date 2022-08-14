package dev.lupluv.bungee;

import dev.lupluv.bungee.files.FileManager;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMain extends Plugin {

    private static BungeeMain bungeeMain;
    private FileManager fileManager;

    @Override
    public void onEnable() {
        bungeeMain = this;
        fileManager = new FileManager();

    }

    @Override
    public void onDisable() {

    }

    public static BungeeMain getBungeeMain() {
        return bungeeMain;
    }

    public FileManager getFileManager() {
        return fileManager;
    }
}
