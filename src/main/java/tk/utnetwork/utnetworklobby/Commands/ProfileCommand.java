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
import tk.utnetwork.utnetworklobby.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Material.STAINED_GLASS_PANE;

public class ProfileCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;


            Inventory inv = null;
            if (p.hasPermission("staff")) {
                inv = Bukkit.createInventory(p, 45, "Profile Settings");

                for (int i = 0; i < 45; i++) {
                    if (i != 10 && i != 13 && i != 16 && i != 28 && i != 31 && i != 34) {
                        ItemStack none = new ItemStack(STAINED_GLASS_PANE, 1, (byte) 7);
                        ItemMeta noneMeta = none.getItemMeta();
                        noneMeta.setDisplayName(Utils.chatRaw("&7"));
                        none.setItemMeta(noneMeta);
                        inv.setItem(i, none);
                    }
                }

                ItemStack item4 = new ItemStack(Material.PAPER);
                ItemMeta item4Meta = item4.getItemMeta();
                item4Meta.setDisplayName(Utils.chatRaw("%sMute Staff Messages"));

                List<String> lore4 = new ArrayList<>();
                lore4.add("");
                lore4.add(Utils.chatRaw("%pEnable or disable the ability to view"));
                lore4.add(Utils.chatRaw("%pall chat messages."));
                lore4.add("");
                lore4.add(Utils.chatRaw("&a&lCLICK TO TOGGLE"));
                lore4.add("");

                item4Meta.setLore(lore4);
                item4.setItemMeta(item4Meta);

                ItemStack item5 = new ItemStack(Material.PAPER);
                ItemMeta item5Meta = item5.getItemMeta();
                item5Meta.setDisplayName(Utils.chatRaw("%sToggle Staff Chat"));

                List<String> lore5 = new ArrayList<>();
                lore5.add("");
                lore5.add(Utils.chatRaw("%pToggle the ability to communicate by viewing"));
                lore5.add(Utils.chatRaw("%pand sending messages through staff chat."));
                lore5.add("");
                lore5.add(Utils.chatRaw("&a&lCLICK TO TOGGLE"));
                lore5.add("");

                item5Meta.setLore(lore5);
                item5.setItemMeta(item5Meta);


                ItemStack item6 = new ItemStack(Material.BARRIER);
                ItemMeta item6Meta = item6.getItemMeta();

                item6Meta.setDisplayName(Utils.chatRaw("%t&lSOON"));
                item6.setItemMeta(item6Meta);

                inv.setItem(28, item4);
                inv.setItem(31, item5);
                inv.setItem(34, item6);
            } else {
                inv = Bukkit.createInventory(p, 27, "Profile Settings");

                for (int i = 0; i < 27; i++) {
                    if (i != 10 && i != 13 && i != 16) {
                        ItemStack none = new ItemStack(STAINED_GLASS_PANE, 1, (byte) 7);
                        ItemMeta noneMeta = none.getItemMeta();
                        noneMeta.setDisplayName(Utils.chatRaw("&7"));
                        none.setItemMeta(noneMeta);
                        inv.setItem(i, none);
                    }
                }
            }
            ItemStack item1 = new ItemStack(Material.PAPER);
            ItemMeta item1Meta = item1.getItemMeta();
            item1Meta.setDisplayName(Utils.chatRaw("%sReceive Private Messages"));

            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(Utils.chatRaw("%pEnable or disable the ability for players"));
            lore.add(Utils.chatRaw("%pto communicate with you through messaging."));
            lore.add("");
            lore.add(Utils.chatRaw("&a&lCLICK TO TOGGLE"));
            lore.add("");

            item1Meta.setLore(lore);
            item1.setItemMeta(item1Meta);

            ItemStack item2 = new ItemStack(Material.PAPER);
            ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.setDisplayName(Utils.chatRaw("%sFriend Requests"));

            List<String> lore2 = new ArrayList<>();
            lore2.add("");
            lore2.add(Utils.chatRaw("%pEnable or disable the ability for"));
            lore2.add(Utils.chatRaw("%pplayers to send you a friend request."));
            lore2.add("");
            lore2.add(Utils.chatRaw("%t&lCURRENTLY UNAVAILABLE"));
            lore2.add("");

            item2Meta.setLore(lore2);
            item2.setItemMeta(item2Meta);

            ItemStack item3 = new ItemStack(Material.PAPER);
            ItemMeta item3Meta = item3.getItemMeta();
            item3Meta.setDisplayName(Utils.chatRaw("%sFriend Teleport"));

            List<String> lore3 = new ArrayList<>();
            lore3.add("");
            lore3.add(Utils.chatRaw("%pEnable or disable the ability for"));
            lore3.add(Utils.chatRaw("%pfriends to teleport to your server."));
            lore3.add("");
            lore3.add(Utils.chatRaw("%t&lCURRENTLY UNAVAILABLE"));
            lore3.add("");

            item3Meta.setLore(lore3);
            item3.setItemMeta(item3Meta);

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
