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
import tk.utnetwork.utnetworklobby.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Material.STAINED_GLASS_PANE;

public class CosmeticsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;

            Inventory inv = Bukkit.createInventory(p, 27, "Cosmetics");

            ItemStack item1 = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemMeta item1Meta = item1.getItemMeta();
            item1Meta.setDisplayName(Utils.chat("%sSuits"));

            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(Utils.chat("%pEquip the suit you like with 9"));
            lore.add(Utils.chat("%pdifferent colors to choose from."));
            lore.add("");

            item1Meta.setLore(lore);
            item1.setItemMeta(item1Meta);

            ItemStack item2 = new ItemStack(Material.FISHING_ROD);
            ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.setDisplayName(Utils.chat("%sGadgets"));

            List<String> lore2 = new ArrayList<>();
            lore2.add("");
            lore2.add(Utils.chat("%pEquip the gadget you like to"));
            lore2.add(Utils.chat("%phave fun in the server lobby."));
            lore2.add("");

            item2Meta.setLore(lore2);
            item2.setItemMeta(item2Meta);

            for (int i = 0; i < 27; i++) {
                if (i != 12 && i != 14) {
                    ItemStack none = new ItemStack(STAINED_GLASS_PANE, 1, (byte) 7);
                    ItemMeta noneMeta = none.getItemMeta();
                    noneMeta.setDisplayName(Utils.chat("&7"));
                    none.setItemMeta(noneMeta);
                    inv.setItem(i, none);
                }
            }

            inv.setItem(12, item1);
            inv.setItem(14, item2);
            p.openInventory(inv);

        } else {
            commandSender.sendMessage(Utils.chat("%tYou need to be a player to use this command."));
        }
        return false;
    }
}
