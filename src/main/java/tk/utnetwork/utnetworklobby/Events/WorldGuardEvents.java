package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import tk.utnetwork.utnetworklobby.Utils.Utils;

public class WorldGuardEvents implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lServer Selector §7(Right-click)") ||
                e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lCosmetics §7(Right-click)") ||
                e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lProfile Settings §7(Right-click)")) {

            e.setCancelled(true);
            p.sendMessage(Utils.chat("%p[%sUT%p] %t&lHey! %tSorry but you can't do that!"));
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lServer Selector §7(Right-click)") ||
                e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lCosmetics §7(Right-click)") ||
                e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lProfile Settings §7(Right-click)")) {

            e.setCancelled(true);
            p.sendMessage(Utils.chat("%p[%sUT%p] %t&lHey! %tSorry but you can't do that!"));
        }
    }
}
