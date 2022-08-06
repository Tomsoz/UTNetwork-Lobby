package tk.utnetwork.utnetworklobby.Events;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.utnetwork.utnetworklobby.Utils.Utils;

public class SpawnCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length > 0) {
                p.sendMessage(Utils.chat("%p[%sUT%p] %tUsage: /" + cmd.getName()));
            } else {
                if (cmd.getName().equalsIgnoreCase("spawn")) {

                    p.teleport(p.getWorld().getSpawnLocation());

                } else if (cmd.getName().equalsIgnoreCase("setspawn") || cmd.getName().equalsIgnoreCase("setworldspawn")) {
                    if (p.hasPermission("staff.setspawn")) {

                        Location loc = p.getLocation();
                        p.getWorld().setSpawnLocation(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
                        p.getWorld().getSpawnLocation().setYaw(loc.getYaw());
                        p.getWorld().getSpawnLocation().setPitch(loc.getPitch());
                        p.sendMessage(Utils.chat("%p[%sUT%p] World spawn set to: %s" + loc.getBlockX() + "%p, %s" + loc.getBlockY() + "%p, %s" + loc.getBlockZ() + "%p."));
                    }
                }
            }
        }
        return false;
    }
}

