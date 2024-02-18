package cn.postudio.pocore;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;

public class FileFunction {

    public static String POFileStoragePath = PoPluginAPI.getPlugin().getDataFolder().getPath();
    private static File POFile;

    public static @NotNull Boolean createNewFile(@NotNull POFileType poFileType, String name) throws IOException {
        switch (poFileType){
            case PlayerData: {
                POFile = new File(POFileStoragePath + "/PlayerData/", name + ".yml");
                return POFile.createNewFile();
            }
            case Lang: {
                POFile = new File(POFileStoragePath + "/Lang/", name + ".yml");
                return POFile.createNewFile();
            }
            default: return false;
        }
    }

    public static @NotNull Boolean createNewFile(File file) throws IOException {
        POFile = file;
        return POFile.createNewFile();
    }


    public static @Nullable File getFile(@NotNull POFileType poFileType, String name){
        switch (poFileType){
            case PlayerData: {
                return new File(POFileStoragePath + "/PlayerData/",name + ".yml");
            }
            case Lang: {
                return new File(POFileStoragePath + "/Lang/", name + ".yml");
            }
            default: return null;
        }
    }

    public static @NotNull FileConfiguration getFileCfg(File file){
        POFile = file;
        return YamlConfiguration.loadConfiguration(POFile);
    }

    public static void writeFile(File file, String key, Object object) throws IOException{
        POFile = file;
        FileConfiguration fileConfiguration = getFileCfg(POFile);
        fileConfiguration.set(key, object);
        fileConfiguration.save(file);
    }

    @Contract(value = " -> new", pure = true)
    public static @NotNull File getPOConfig(){
        return new File(POFileStoragePath + "/Config.yml");
    }
}
