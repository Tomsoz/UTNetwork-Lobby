package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;

public class WorldGuardEvents implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();

        if (!p.hasPermission("staff.inventory.drop")) {
            e.setCancelled(true);

        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getType() == InventoryType.PLAYER) {
            if (!p.hasPermission("staff.inventory.move")) {
                e.setCancelled(true);
            }
        }
    }
}
