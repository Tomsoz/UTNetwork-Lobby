package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
            if (e.getClick() == ClickType.NUMBER_KEY) {
                e.setCancelled(true);
            }
            if (e.getClick() == ClickType.CREATIVE) {
                e.setCancelled(true);
            }

            List<Integer> slots = new ArrayList<>();
            slots.add(0);
            slots.add(4);
            slots.add(8);

            List<ItemStack> armor = new ArrayList<>();
            if (p.getEquipment().getHelmet() != null) {
                armor.add(Objects.requireNonNull(p.getEquipment().getHelmet()));
            }
            if (p.getEquipment().getChestplate() != null) {
                armor.add(Objects.requireNonNull(p.getEquipment().getChestplate()));
            }
            if (p.getEquipment().getLeggings() != null) {
                armor.add(Objects.requireNonNull(p.getEquipment().getLeggings()));
            }
            if (p.getEquipment().getBoots() != null) {
                armor.add(Objects.requireNonNull(p.getEquipment().getBoots()));
            }

            if (slots.contains(e.getSlot()) || (armor.contains(e.getCurrentItem())) && (e.getClickedInventory().getType() == InventoryType.PLAYER)) {
                e.setCancelled(true);
            }
        }
    }
}
