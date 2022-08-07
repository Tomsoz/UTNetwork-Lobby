package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tk.utnetwork.utnetworklobby.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class JoinAndQuitEvent implements Listener {

    List<ItemStack> itemList = new ArrayList<>();
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        e.setJoinMessage(Utils.chat("%s" + p.getCustomName() + " %phas joined your lobby!"));

        ItemStack item1 = new ItemStack(Material.NETHER_STAR);
        ItemMeta item1Meta = item1.getItemMeta();
        item1Meta.setDisplayName("§e§lServer Selector §7(Right-click)");
        item1.setItemMeta(item1Meta);

        ItemStack item2 = new ItemStack(Material.CHEST);
        ItemMeta item2Meta = item2.getItemMeta();
        item2Meta.setDisplayName("§e§lCosmetics §7(Right-click)");
        item2.setItemMeta(item2Meta);

        ItemStack item3 = new ItemStack(Material.PAPER);
        ItemMeta item3Meta = item3.getItemMeta();
        item3Meta.setDisplayName("§e§lProfile Settings §7(Right-click)");
        item3.setItemMeta(item3Meta);

        ItemStack currentCosmetic = p.getInventory().getItem(3);

        p.getInventory().clear();

        p.getInventory().setItem(0, item1);
        p.getInventory().setItem(3, currentCosmetic);
        p.getInventory().setItem(4, item2);
        p.getInventory().setItem(8, item3);
    }

    public void addStack(Material item, String name) {

        ItemStack itemAdd = new ItemStack(item);
        ItemMeta itemAddMeta = itemAdd.getItemMeta();
        itemAddMeta.setDisplayName(name);
        itemAdd.setItemMeta(itemAddMeta);

        itemList.add(itemAdd);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Player p = e.getPlayer();
        e.setQuitMessage(Utils.chat("%s" + p.getCustomName() + " %phas left your lobby!"));

    }
}
