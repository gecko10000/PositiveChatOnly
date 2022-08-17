package gecko10000.positivechatonly;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.audience.Audience;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public class PositiveChatOnly extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler (priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onChat(AsyncChatEvent event) {
        Player source = event.getPlayer();
        Set<Audience> viewers = event.viewers();
        viewers.forEach(a -> a.sendMessage(event.renderer().render(
                source,
                source.displayName(),
                event.message(),
                a)));
        viewers.clear();
    }

}
