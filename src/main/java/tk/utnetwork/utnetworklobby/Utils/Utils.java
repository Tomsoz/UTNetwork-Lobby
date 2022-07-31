package tk.utnetwork.utnetworklobby.Utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import tk.utnetwork.utnetworklobby.UTNetworkLobby;

public class Utils {

    public static String chat(String textToTranslate) {
        return ChatColor.translateAlternateColorCodes('&', textToTranslate);
    }

    public static void log(String logToExecute) {
        logToExecute = chat(logToExecute);
        Bukkit.getConsoleSender().sendMessage(logToExecute);
    }

    static UTNetworkLobby plugin;

    public Utils(UTNetworkLobby plugin) {
        this.plugin = plugin;
    }

    public void Player(Player p ,String serverName, Plugin plugin) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF(server);

        p.sendPluginMessage(UTNetworkLobby, "BungeeCord", out.toByteArray());
        return;
    }

}
