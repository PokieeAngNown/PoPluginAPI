package cn.postudio.pocore;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LangHandler {

    public static String getLangContent(String pluginName, String key) {
        File file = FileFunction.getFile(POFileType.Lang, pluginName + "-" +PoPluginAPI.getPlugin().getConfig().getString("Language") + ".yml");
        assert file != null;
        FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(file);
        List<String> stringList = fileConfiguration.getStringList(key);
        if (stringList.equals(new ArrayList<>())){
            return Objects.requireNonNull(fileConfiguration.getString(key));
        }else{
            return String.join("\n", stringList);
        }
    }
}
