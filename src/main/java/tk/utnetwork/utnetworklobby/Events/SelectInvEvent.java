package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import tk.utnetwork.utnetworklobby.Utils.Utils;

public class SelectInvEvent implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (p.getItemInHand().getType().equals(Material.NETHER_STAR) &&
                    p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lServer Selector §7(Right-click)")) {

                e.setCancelled(true);
                p.chat("/serverselector");
            } else if (p.getItemInHand().getType().equals(Material.CHEST) &&
                    p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lCosmetics §7(Right-click)")) {

                e.setCancelled(true);
                p.chat("/cosmetics");
            } else if (p.getItemInHand().getType().equals(Material.PAPER) &&
                    p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lProfile Settings §7(Right-click)")) {

                e.setCancelled(true);
                p.chat("/profile");
            }
        }
    }
}
