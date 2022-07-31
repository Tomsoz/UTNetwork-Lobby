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

            Inventory inv = Bukkit.createInventory(p, 27);

            ItemStack item1 = new ItemStack(Material.GRASS);
            ItemMeta item1Meta = item1.getItemMeta();
            item1Meta.setDisplayName(Utils.chat("&f&lLifeSteal"));
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add("&8- &7Public Minecraft SMP with the risk");
            lore.add(" &8 &7of losing your hearts.");
            lore.add("");
            lore.add("&8- Online: " + Utils.getPluginMessageResponse("PlayerCount__lifesteal"));
            lore.add("");
            lore.add("&aClick to connect to &f&lLifeSteal");


            item1.setItemMeta(item1Meta);



        }




        return false;
    }
}
