package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WorldGuardEvents implements Listener {

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();

        if (!p.hasPermission("staff.inventory.drop")) {
            e.setCancelled(true);

        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (!p.hasPermission("staff.inventory.move")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onHungerDrain(FoodLevelChangeEvent e) {
        e.setCancelled(true);
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (p.getFoodLevel() < 20) {
                p.setFoodLevel(20);
            }
        }
    }

    @EventHandler
    public void onHealthLoss(EntityDamageEvent e) {
        e.setCancelled(true);
    }
}
