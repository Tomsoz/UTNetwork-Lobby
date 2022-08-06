package tk.utnetwork.utnetworklobby.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.utnetwork.utnetworklobby.UTNetworkLobby;
import tk.utnetwork.utnetworklobby.Utils.Utils;

public class LifeStealCommand implements CommandExecutor {

    static UTNetworkLobby plugin;

    public LifeStealCommand(UTNetworkLobby plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            p.sendMessage(Utils.chat("%p[%sUT%p] Sending you to &fLifeSteal%s."));
            Utils.sendPluginMessage("Connect", p, "lifesteal", plugin);
        } else {

            sender.sendMessage(Utils.chat("%p[%sUT%p] %tYou need to be a player to use this command!"));
        }


        return false;
    }
}
