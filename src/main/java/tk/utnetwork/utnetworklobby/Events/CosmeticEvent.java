package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import tk.utnetwork.utnetworklobby.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Material.*;

public class CosmeticEvent implements Listener {

    List<ItemStack> items = new ArrayList<>();

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getTitle().equalsIgnoreCase("Cosmetics")) {
            e.setCancelled(true);

            if (e.getSlot() == 12) {

                Inventory inv = Bukkit.createInventory(p, 27, "Suits");

                for (int i = 0; i < 27; i++) {
                    ItemStack none = new ItemStack(STAINED_GLASS_PANE, 1, (byte) 7);
                    ItemMeta noneMeta = none.getItemMeta();
                    noneMeta.setDisplayName(Utils.chat("&7"));
                    none.setItemMeta(noneMeta);
                    inv.setItem(i, none);
                }

                addStack(p, "&5Purple Suit", Color.PURPLE);
                addStack(p, "&1Blue Suit", Color.NAVY);
                addStack(p, "&fSilver Suit", Color.SILVER);
                addStack(p, "&7Gray Suit", Color.GRAY);
                addStack(p, "&aLime Suit", Color.LIME);
                addStack(p, "&dPink Suit", Color.FUCHSIA);
                addStack(p, "&3Light Blue Suit", Color.TEAL);
                addStack(p, "&4Red Suit", Color.MAROON);
                addStack(p, "&6Orange Suit", Color.ORANGE);

                int count = 9;
                for (ItemStack item : items) {
                    if (count != 18) {
                        inv.setItem(count, item);
                        count++;
                    }
                }
                items.clear();
                p.openInventory(inv);
            }
        } else if (e.getInventory().getTitle().equalsIgnoreCase("Suits")) {
            e.setCancelled(true);

            if (e.getSlot() == 9) {
                setArmor(p, Color.PURPLE, "&5Purple Suit");
            } else if (e.getSlot() == 10) {
                setArmor(p, Color.NAVY, "&1Blue Suit");
            } else if (e.getSlot() == 11) {
                setArmor(p, Color.SILVER, "&fSilver Suit");
            } else if (e.getSlot() == 12) {
                setArmor(p, Color.GRAY, "&7Gray Suit");
            } else if (e.getSlot() == 13) {
                setArmor(p, Color.LIME, "&aLime Suit");
            } else if (e.getSlot() == 14) {
                setArmor(p, Color.FUCHSIA, "&dPink Suit");
            } else if (e.getSlot() == 15) {
                setArmor(p, Color.TEAL, "&3Light Blue Suit");
            } else if (e.getSlot() == 16) {
                setArmor(p, Color.MAROON, "&4Red Suit");
            } else if (e.getSlot() == 17) {
                setArmor(p, Color.ORANGE, "&6Orange Suit");
            }

        }
    }

    public void addStack(Player p, String name, Color color) {

        name = Utils.chat(name);

        ItemStack item = new ItemStack(LEATHER_CHESTPLATE);

        List<String> lore = new ArrayList<>();
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) item.getItemMeta();

        lore.add("");
        if (p.getEquipment().getHelmet() != null) {

            if (p.getEquipment().getHelmet().hasItemMeta()) {

                LeatherArmorMeta meta = (LeatherArmorMeta) p.getEquipment().getHelmet().getItemMeta();

                if (String.valueOf(meta.getColor()).equalsIgnoreCase(String.valueOf(color))) {

                    itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    lore.add(Utils.chat("&aEquipped"));
                    lore.add(Utils.chat("&7Un-equipped"));

                } else {
                    lore.add(Utils.chat("&7Equipped"));
                    lore.add(Utils.chat("&cUn-equipped"));
                }

            } else {
                lore.add(Utils.chat("&7Equipped"));
                lore.add(Utils.chat("&cUn-equipped"));
            }

        } else {
            lore.add(Utils.chat("&7Equipped"));
            lore.add(Utils.chat("&cUn-equipped"));
        }

        lore.add("");

        itemMeta.setColor(color);
        itemMeta.setDisplayName(name);

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);

        items.add(item);

    }

    public void setArmor(Player p, Color color, String colorS) {

        if (p.getEquipment().getHelmet() != null) {

            if (p.getEquipment().getHelmet().hasItemMeta()) {

                LeatherArmorMeta meta = (LeatherArmorMeta) p.getEquipment().getHelmet().getItemMeta();

                if (String.valueOf(meta.getColor()).equalsIgnoreCase(String.valueOf(color))) {

                    p.getEquipment().setHelmet(null);
                    p.getEquipment().setChestplate(null);
                    p.getEquipment().setLeggings(null);
                    p.getEquipment().setBoots(null);
                    p.sendMessage(Utils.chat("%p[%sUT%p] Un-equipped suit: " + colorS + "%p."));
                    p.closeInventory();
                    return;

                }
            }
        }

        ItemStack helmet = new ItemStack(LEATHER_HELMET);
        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
        helmetMeta.setColor(color);
        helmetMeta.setDisplayName(Utils.chat(colorS));
        helmetMeta.spigot().setUnbreakable(true);
        helmet.setItemMeta(helmetMeta);

        ItemStack chestplate = new ItemStack(LEATHER_CHESTPLATE);
        LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        chestMeta.setColor(color);
        chestMeta.setDisplayName(Utils.chat(colorS));
        chestMeta.spigot().setUnbreakable(true);
        chestplate.setItemMeta(chestMeta);

        ItemStack leggings = new ItemStack(LEATHER_LEGGINGS);
        LeatherArmorMeta legMeta = (LeatherArmorMeta) leggings.getItemMeta();
        legMeta.setColor(color);
        legMeta.setDisplayName(Utils.chat(colorS));
        legMeta.spigot().setUnbreakable(true);
        leggings.setItemMeta(legMeta);

        ItemStack boots = new ItemStack(LEATHER_BOOTS);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setColor(color);
        bootsMeta.setDisplayName(Utils.chat(colorS));
        bootsMeta.spigot().setUnbreakable(true);
        boots.setItemMeta(bootsMeta);

        p.getEquipment().setHelmet(helmet);
        p.getEquipment().setChestplate(chestplate);
        p.getEquipment().setLeggings(leggings);
        p.getEquipment().setBoots(boots);

        p.closeInventory();
        p.sendMessage(Utils.chat("%p[%sUT%p] Equipped suit: " + colorS + "%p."));
    }
}

