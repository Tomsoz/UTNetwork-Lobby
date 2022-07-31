package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import tk.utnetwork.utnetworklobby.Utils.Utils;

public class SelectEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("Server Selector")) {
            e.setCancelled(true);
            p.closeInventory();
            p.sendMessage(Utils.chat("%cThis is currently unavailable, please try again later!"));
        }

    }
}
