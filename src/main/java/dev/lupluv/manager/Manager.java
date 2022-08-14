package dev.lupluv.manager;

import dev.lupluv.bungee.BungeeMain;
import dev.lupluv.bungee.files.FileConfiguration;
import dev.lupluv.bungee.files.YamlConfiguration;
import dev.lupluv.manager.mysql.MySQL;
import dev.lupluv.manager.utils.PluginType;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;

public class Manager {

    private static Manager manager;

    private MySQL mySQL;
    public static PluginType pluginType;

    // Services



    // Usefull Methods
    public static void sendColoredConsoleMessage(String msg){
        if(pluginType == PluginType.BUNGEE){
            ProxyServer.getInstance().getConsole().sendMessage(new TextComponent(msg));
        }else if(pluginType == PluginType.SPIGOT){
            Bukkit.getConsoleSender().sendMessage(msg);
        }
    }


    // OnEnable
    public void onEnable(){

        manager = new Manager();


    }

    // Reload the MySQL Connection
    public static void reloadMysql() throws IOException {
        if(pluginType == PluginType.BUNGEE) {
            File file = BungeeMain.getBungeeMain().getFileManager().getMysqlFile();
            if(file.exists()) {
                FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                if (getManager().getMySQL().isConnected()) {
                    getManager().getMySQL().disconnect();
                }
                manager.mySQL = new MySQL(cfg.getString("Host"), cfg.getString("Port"), cfg.getString("Database")
                        , cfg.getString("Username"), cfg.getString("Password"));
                manager.mySQL.connect();
                if(manager.mySQL.isConnected()){
                    manager.mySQL.update("CREATE TABLE IF NOT EXISTS social_users (ID BIGINT(100),UUID VARCHAR(100),STATUS VARCHAR(1000)" +
                            ",LAST_ONLINE BIGINT(100),CURRENT_SERVER VARCHAR(100),JUMPING VARCHAR(100),REQUESTS VARCHAR(100),MESSAGES VARCHAR(100)" +
                            ",ONLINE_NOTIFY VARCHAR(100),FIRST_JOIN VARCHAR(100),ONLINE_TIME BIGINT(1000000));");
                    manager.mySQL.update("CREATE TABLE IF NOT EXISTS social_friendships (ID BIGINT(100),USER1 BIGINT(100),USER2 BIGINT(100)" +
                            ",FAV1 VARCHAR(100),FAV2 VARCHAR(100),DATE VARCHAR(100));");
                    manager.mySQL.update("CREATE TABLE IF NOT EXISTS social_links (USER BIGINT(100),YOUTUBE_NAME VARCHAR(100),YOUTUBE_LINK VARCHAR(100)" +
                            ",TWITCH_NAME VARCHAR(100),TWITCH_LINK VARCHAR(100),DISCORD_NAME VARCHAR(100),DISCORD_TAG VARCHAR(100),EMAIL VARCHAR(100));");
                    manager.mySQL.update("CREATE TABLE IF NOT EXISTS social_requests (ID BIGINT(100),TYPE VARCHAR(100),VAL1 BIGINT(100)" +
                            ",VAL2 BIGINT(100),DATE VARCHAR(100));");
                }
            }else{
                sendColoredConsoleMessage(MySQL.mysqlPrefix + "§cCould not create the MySQL Connection. Reason: mysql.yml File doesnt exist | " +
                        "Tip: Restart the Plugin and watch out for File Exceptions");
            }
        }
    }


    // Getters
    public MySQL getMySQL() {
        return mySQL;
    }
    public static Manager getManager() {
        return manager;
    }
}
