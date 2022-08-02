package tk.utnetwork.utnetworklobby.Commands;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tk.utnetwork.utnetworklobby.UTNetworkLobby;
import tk.utnetwork.utnetworklobby.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Material.STAINED_GLASS_PANE;

public class ServerSelectorCommand implements CommandExecutor {
    UTNetworkLobby plugin;
    public ServerSelectorCommand(UTNetworkLobby plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;


            Inventory inv = Bukkit.createInventory(p, 27, "Server Selector");

            ItemStack item1 = new ItemStack(Material.GRASS);
            ItemMeta item1Meta = item1.getItemMeta();
            item1Meta.setDisplayName(Utils.chat("&f&lLifeSteal"));

            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(Utils.chat("&8- &7Public Minecraft SMP with the risk"));
            lore.add(Utils.chat(" &8 &7of losing all of your hearts."));
            lore.add("");
            lore.add(Utils.chat("&8- &7Online: &a") + PlaceholderAPI.setPlaceholders(p, "%premiumvanish_bungeeplayercount@lifesteal%") + Utils.chat("&8/&a50"));
            lore.add("");
            lore.add(Utils.chat("&aClick to connect to &f&lLifeSteal"));

            item1Meta.setLore(lore);
            item1.setItemMeta(item1Meta);

            ItemStack item2 = new ItemStack(Material.BARRIER);
            ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.setDisplayName(Utils.chat("&c&lSOON"));
            item2.setItemMeta(item2Meta);

            ItemStack item3 = new ItemStack(Material.BARRIER);
            ItemMeta item3Meta = item3.getItemMeta();
            item3Meta.setDisplayName(Utils.chat("&c&lSOON"));
            item3.setItemMeta(item3Meta);

            for (int i = 0; i < 27; i++) {
                if (i != 10) {
                    if (i != 13) {
                        if (i != 16) {
                            ItemStack none = new ItemStack(STAINED_GLASS_PANE, 1, (byte)7);
                            ItemMeta noneMeta = none.getItemMeta();
                            noneMeta.setDisplayName(Utils.chat("&7"));
                            none.setItemMeta(noneMeta);
                            inv.setItem(i, none);
                        }
                    }
                }
            }

            inv.setItem(10, item1);
            inv.setItem(13, item2);
            inv.setItem(16, item3);
            p.openInventory(inv);

        } else {
            commandSender.sendMessage(Utils.chat("%tYou need to be a player to use this command."));
        }




        return false;
    }
}
