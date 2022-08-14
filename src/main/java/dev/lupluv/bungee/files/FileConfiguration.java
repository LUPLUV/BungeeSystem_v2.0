package dev.lupluv.bungee.files;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileConfiguration {

    File file;
    Configuration configuration;

    public FileConfiguration(File file) throws IOException {
        this.file = file;
        configuration = YamlConfiguration.getProvider(YamlConfiguration.class).load(file);
    }

    public void save() throws IOException {
        YamlConfiguration.getProvider(YamlConfiguration.class).save(configuration, file);
    }

    public void save(File file) throws IOException {
        YamlConfiguration.getProvider(YamlConfiguration.class).save(configuration, file);
    }

    public void set(String key, Object obj){
        configuration.set(key, obj);
    }

    public String getString(String key){
        return configuration.getString(key);
    }

    public boolean getBoolean(String key){
        return configuration.getBoolean(key);
    }

    public int getInt(String key){
        return configuration.getInt(key);
    }

    public long getLong(String key){
        return configuration.getLong(key);
    }

    public double getDouble(String key){
        return configuration.getDouble(key);
    }

    public float getFloat(String key){
        return configuration.getFloat(key);
    }

    public List<?> getList(String key){
        return configuration.getList(key);
    }

    public List<String> getStringList(String key){
        return configuration.getStringList(key);
    }

    public Map<String, String> getStringMap(String key){
        Map<String, String> map = new HashMap<>();
        List<String> list = configuration.getStringList(key);
        for(String s : list){
            String[] parts = s.replace("{", "").replace("}", "").split(">°<");
            map.put(parts[0], parts[1]);
        }
        return map;
    }

}
