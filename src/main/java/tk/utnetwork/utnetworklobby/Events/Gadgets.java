package tk.utnetwork.utnetworklobby.Events;

import com.google.common.collect.HashBiMap;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import tk.utnetwork.utnetworklobby.Utils.Utils;

import java.util.HashMap;
import java.util.UUID;

public class Gadgets implements Listener {
    HashMap<UUID, Integer> slowballCooldown = new HashMap<>();
    HashMap<UUID, Integer> repellentCooldown = new HashMap<>();

    // GRAPPLING HOOK
    @EventHandler
    public void onFish(PlayerFishEvent e) {
        Player p = e.getPlayer();
        if (e.getState().equals(PlayerFishEvent.State.FISHING)) return;
        try {
            p.setVelocity(p.getLocation().getDirection().multiply(6.0).setY(1.25));
        } catch (Exception ex) { }
    }

    // SLOWBALLS
    @EventHandler
    public void projectileHit(ProjectileHitEvent e) {
        if (e.getEntity().getType() != EntityType.SNOWBALL) return;
        Snowball ball = (Snowball) e.getEntity();
        if (!(ball.getShooter() instanceof Player)) return;
        Player p = (Player)ball.getShooter();
        if (slowballCooldown.containsKey(p.getUniqueId())) {
            p.sendMessage(Utils.chat("%tYou're still on cooldown for" + Utils.formatTime(slowballCooldown.get(p.getUniqueId())) + "."));
            return;
        }
        int i = 0;
        for (Entity entity : ball.getNearbyEntities(5, 5, 5)) {
            if (!(entity instanceof Player)) continue;
            Player target = (Player) entity;
            target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1, true, true));
            target.sendMessage(Utils.chat("%pYou've been given slowness by %s" + p.getDisplayName() + "%p's slowball."));
            i++;
        }
        slowballCooldown.put(p.getUniqueId(), 60);
        p.sendMessage(Utils.chat("%pYou've got %s" + i + " %ppeople with your slowball."));
    }

    // STAFF REPELLENT
    @EventHandler
    public void entityDamageByEntity(EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player) || !(e.getDamager() instanceof Player)) return;
        Player attacker = (Player) e.getDamager();
        Player victim = (Player) e.getEntity();

        if (attacker.getItemInHand().getItemMeta().hasDisplayName() ? attacker.getItemInHand().getItemMeta().getDisplayName().equals(Utils.chatRaw("&bStaff Repellent")) : false) {
            if (!victim.hasPermission("staff")) {
                attacker.sendMessage(Utils.chat("%tThis player is not staff."));
                return;
            }
            if (repellentCooldown.containsKey(attacker.getUniqueId())) {
                attacker.sendMessage(Utils.chat("%tYou're still on cooldown for" + Utils.formatTime(repellentCooldown.get(attacker.getUniqueId())) + "."));
                return;
            }
            victim.setVelocity(new Vector(victim.getVelocity().getX(), 100, victim.getVelocity().getZ()));
            repellentCooldown.put(attacker.getUniqueId(), 120);
        }
    }
}
