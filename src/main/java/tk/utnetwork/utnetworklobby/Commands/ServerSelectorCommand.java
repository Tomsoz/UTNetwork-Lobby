package tk.utnetwork.utnetworklobby.Commands;

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

public class ServerSelectorCommand implements CommandExecutor {
    UTNetworkLobby plugin;
    public ServerSelectorCommand(UTNetworkLobby plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;

            Utils.sendPluginMessage("PlayerCount", p, "lifesteal", plugin);

            // Utils.sendPluginMessage("PlayerCount", p, "servername", plugin);
            // to get the response:
            // Utils.getPluginMessageResponse("PlayerCount__servername);

            Inventory inv = Bukkit.createInventory(p, 27, "Server Selector");

            ItemStack item1 = new ItemStack(Material.GRASS);
            ItemMeta item1Meta = item1.getItemMeta();
            item1Meta.setDisplayName(Utils.chat("&f&lLifeSteal"));

            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add("&8- &7Public Minecraft SMP with the risk");
            lore.add(" &8 &7of losing all of your hearts.");
            lore.add("");
            lore.add("&8- &7Online: &a" + Utils.getPluginMessageResponse("PlayerCount__lifesteal" + "&8/&a50"));
            lore.add("");
            lore.add("&aClick to connect to &f&lLifeSteal");
            item1Meta.setLore(lore);

            item1.setItemMeta(item1Meta);

            ItemStack item2 = new ItemStack(Material.BARRIER);
            ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.setDisplayName(Utils.chat("&c&lSOON"));

            ItemStack item3 = new ItemStack(Material.BARRIER);
            ItemMeta item3Meta = item3.getItemMeta();
            item3Meta.setDisplayName(Utils.chat("&c&lSOON"));

            inv.setItem(10, item1);
            inv.setItem(12, item2);
            inv.setItem(14, item3);
            p.openInventory(inv);

//useful for later
//Utils.sendPluginMessage("Connect", p, "lifesteal", plugin);

        } else {
            commandSender.sendMessage(Utils.chat("%cYou need to be a player to use this command."));
        }




        return false;
    }
}
