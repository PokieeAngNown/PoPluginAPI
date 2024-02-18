package cn.postudio.pocore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class PoPluginAPI extends JavaPlugin {

    public static Plugin getPlugin(){
        return Bukkit.getPluginManager().getPlugin("PoPluginAPI");
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        initializePluginFile();
        getServer().getPluginManager().registerEvents(new InitializePlayerData(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void initializePluginFile(){
        if (!new File(FileFunction.POFileStoragePath + "Config.yml").exists()){
            this.saveResource("Config.yml", false);
        }
        Path path;
        try {
            path = Paths.get(FileFunction.POFileStoragePath, "PlayerData");
            Files.createDirectories(path);
            path = Paths.get(FileFunction.POFileStoragePath, "Lang");
            Files.createDirectories(path);
        }catch (IOException ignored) {}
    }
}
