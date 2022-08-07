package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
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

    List<ItemStack> suits = new ArrayList<>();

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
                for (ItemStack item : suits) {
                    if (count != 18) {
                        inv.setItem(count, item);
                        count++;
                    }
                }
                suits.clear();
                p.openInventory(inv);
            } else if (e.getSlot() == 14) {

                Inventory inv = Bukkit.createInventory(p, 27, "Gadgets");

                for (int i = 0; i < 27; i++) {
                    ItemStack none = new ItemStack(STAINED_GLASS_PANE, 1, (byte) 7);
                    ItemMeta noneMeta = none.getItemMeta();
                    noneMeta.setDisplayName(Utils.chat("&7"));
                    none.setItemMeta(noneMeta);
                    inv.setItem(i, none);
                }
//-ITEM_1----------------------------------------------------------------------------------
                ItemStack item1 = new ItemStack(FISHING_ROD, 1);
                ItemMeta item1Meta = item1.getItemMeta();
                item1Meta.setDisplayName(Utils.chat("&bGrappling Hook"));

                List<String> lore = new ArrayList<>();
                lore.add("");
                lore.add(Utils.chat("&3Right-click to grapple and launch"));
                lore.add(Utils.chat("&3in the direction you are facing!"));
                lore.add("");
                if (equipCheck(p, FISHING_ROD, Utils.chat("&bGrappling Hook"))) {
                    item1Meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    item1Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    lore.add(Utils.chat("&aEquipped"));
                    lore.add(Utils.chat("&7Un-equipped"));
                } else {
                    lore.add(Utils.chat("&7Equipped"));
                    lore.add(Utils.chat("&cUn-equipped"));
                }
                lore.add("");
                item1Meta.setLore(lore);
                item1.setItemMeta(item1Meta);
//-ITEM_2----------------------------------------------------------------------------------
                ItemStack item2 = new ItemStack(SNOW_BALL, 1);
                ItemMeta item2Meta = item2.getItemMeta();
                item2Meta.setDisplayName(Utils.chat("&bSlowball Launcher"));

                List<String> lore2 = new ArrayList<>();
                lore2.add("");
                lore2.add(Utils.chat("&3Right-click to shoot as many"));
                lore2.add(Utils.chat("&3snowballs to slow down players!"));
                lore2.add("");
                if (equipCheck(p, SNOW_BALL, Utils.chat("&bSlowball Launcher"))) {
                    item2Meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    item2Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    lore2.add(Utils.chat("&aEquipped"));
                    lore2.add(Utils.chat("&7Un-equipped"));
                } else {
                    lore2.add(Utils.chat("&7Equipped"));
                    lore2.add(Utils.chat("&cUn-equipped"));
                }
                lore2.add("");
                item2Meta.setLore(lore2);
                item2.setItemMeta(item2Meta);
//-ITEM_3----------------------------------------------------------------------------------
                ItemStack item3 = new ItemStack(STICK, 1);
                ItemMeta item3Meta = item3.getItemMeta();
                item3Meta.setDisplayName(Utils.chat("&bStaff Repellent"));

                List<String> lore3 = new ArrayList<>();
                lore3.add("");
                lore3.add(Utils.chat("&3Right-click to punch online"));
                lore3.add(Utils.chat("&3Staff Team members in the air!"));
                lore3.add("");
                if (equipCheck(p, STICK, Utils.chat("&bStaff Repellent"))) {
                    item3Meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    item3Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    lore3.add(Utils.chat("&aEquipped"));
                    lore3.add(Utils.chat("&7Un-equipped"));
                } else {
                    lore3.add(Utils.chat("&7Equipped"));
                    lore3.add(Utils.chat("&cUn-equipped"));
                }
                lore3.add("");
                item3Meta.setLore(lore3);
                item3.setItemMeta(item3Meta);

                inv.setItem(11, item1);
                inv.setItem(13, item2);
                inv.setItem(15, item3);
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

        } else if (e.getInventory().getTitle().equalsIgnoreCase("Gadgets")) {
            e.setCancelled(true);
            if (e.getSlot() == 11) {
                setGadget(p, FISHING_ROD, "&bGrappling Hook");
            } else if (e.getSlot() == 13) {
                setGadget(p, SNOW_BALL, "&bSlowball Launcher");
            } else if (e.getSlot() == 15) {
                setGadget(p, STICK, "&bStaff Repellent");
            }
        }
    }

    public void addStack(Player p, String name, Color color) {

        name = Utils.chat(name);

        ItemStack item = new ItemStack(LEATHER_CHESTPLATE, 1);

        List<String> lore = new ArrayList<>();
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) item.getItemMeta();

        lore.add("");
        if (p.getEquipment().getHelmet() != null) {

            if (p.getEquipment().getHelmet().hasItemMeta()) {

                LeatherArmorMeta meta = (LeatherArmorMeta) p.getEquipment().getHelmet().getItemMeta();

                if (String.valueOf(meta.getColor()).equalsIgnoreCase(String.valueOf(color))) {

                    itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
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

        suits.add(item);

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

    public void setGadget(Player p, Material item, String name) {
        name = Utils.chat(name);

        if (equipCheck(p, item, name)) {
            for (ItemStack items : p.getInventory().getContents()) {
                if (items != null) {
                    if (items.hasItemMeta()) {
                        if (items.getType() == item) {
                            if (items.getItemMeta().getDisplayName().equalsIgnoreCase(name)) {
                                p.getInventory().remove(items);
                                p.sendMessage(Utils.chat("%p[%sUT%p] Un-equipped gadget: " + name + "%p."));
                                p.closeInventory();
                                return;
                            }
                        }
                    }
                }
            }
        }

        ItemStack gadget = new ItemStack(item);
        ItemMeta gadgetMeta = gadget.getItemMeta();
        gadgetMeta.setDisplayName(name);
        gadgetMeta.spigot().setUnbreakable(true);
        gadget.setItemMeta(gadgetMeta);

        p.getInventory().setItem(3, gadget);

        p.closeInventory();
        p.sendMessage(Utils.chat("%p[%sUT%p] Equipped gadget: " + name + "%p."));
    }

    public boolean equipCheck(Player p, Material item, String name) {
        for (ItemStack items : p.getInventory().getContents()) {
            if (items != null) {
                if (items.hasItemMeta()) {
                    if (items.getType() == item) {
                        if (items.getItemMeta().getDisplayName().equalsIgnoreCase(name)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

