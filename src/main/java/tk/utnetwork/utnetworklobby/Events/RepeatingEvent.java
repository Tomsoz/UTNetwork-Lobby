package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import tk.utnetwork.utnetworklobby.UTNetworkLobby;
import tk.utnetwork.utnetworklobby.Utils.Utils;

public class RepeatingEvent extends BukkitRunnable {
    UTNetworkLobby plugin;
    public RepeatingEvent(UTNetworkLobby plugin) {
        this.plugin = plugin;
    }
    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (plugin.getGadgetsManager().slowballCooldown.containsKey(p.getUniqueId())) {
                plugin.getGadgetsManager().slowballCooldown.replace(p.getUniqueId(), plugin.getGadgetsManager().slowballCooldown.get(p.getUniqueId()), plugin.getGadgetsManager().slowballCooldown.get(p.getUniqueId()) - 1);
                if (plugin.getGadgetsManager().slowballCooldown.get(p.getUniqueId()) == 0) {
                    plugin.getGadgetsManager().slowballCooldown.remove(p.getUniqueId());
                    p.sendMessage(Utils.chat("%pYour slowball cooldown has expired."));
                }
            }
            if (plugin.getGadgetsManager().repellentCooldown.containsKey(p.getUniqueId())) {
                plugin.getGadgetsManager().repellentCooldown.replace(p.getUniqueId(), plugin.getGadgetsManager().repellentCooldown.get(p.getUniqueId()), plugin.getGadgetsManager().repellentCooldown.get(p.getUniqueId()) - 1);
                if (plugin.getGadgetsManager().repellentCooldown.get(p.getUniqueId()) == 0) {
                    plugin.getGadgetsManager().repellentCooldown.remove(p.getUniqueId());
                    p.sendMessage(Utils.chat("%pYour staff repellent cooldown has expired."));
                }
            }
        }
    }
}
