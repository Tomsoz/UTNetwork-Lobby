package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import tk.utnetwork.utnetworklobby.UTNetworkLobby;
import tk.utnetwork.utnetworklobby.Utils.Utils;

public class SelectEvent implements Listener {

    static UTNetworkLobby plugin;

    public SelectEvent(UTNetworkLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getTitle().equalsIgnoreCase("Server Selector")) {
            e.setCancelled(true);
            if (e.getSlot() == 10) {
                p.closeInventory();
                p.sendMessage(Utils.chat("%p[%sUT%p] Sending you to: &f&lLifeSteal%3."));
                Utils.sendPluginMessage("Connect", p, "lifesteal", plugin);
            } else {
                p.closeInventory();
                p.sendMessage(Utils.chat("%p[%sUT%p] %tThis mode is currently unavailable, please try again later!"));

            }
        }

    }
}
