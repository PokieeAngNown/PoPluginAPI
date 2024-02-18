package cn.postudio.pocore;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;

public class InitializePlayerData implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void playerJoinServerEvent(@NotNull PlayerJoinEvent playerJoinEvent){
        Player player = playerJoinEvent.getPlayer();
        UUID uuid = player.getUniqueId();
        try {
            FileFunction.createNewFile(POFileType.PlayerData, String.valueOf(uuid));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
