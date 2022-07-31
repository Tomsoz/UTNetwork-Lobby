package tk.utnetwork.utnetworklobby.Utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import jdk.tools.jlink.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import tk.utnetwork.utnetworklobby.UTNetworkLobby;

import java.util.HashMap;

public class Utils {

    public static String chat(String textToTranslate) {
        return ChatColor.translateAlternateColorCodes('&', textToTranslate);
    }

    public static void log(String logToExecute) {
        logToExecute = chat(logToExecute);
        Bukkit.getConsoleSender().sendMessage(logToExecute);
    }

    public static void sendPluginMessage(String type, Player p, String server, UTNetworkLobby plugin) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF(type);
        out.writeUTF(server);

        p.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
        return;
    }

    static HashMap<String, String> messages = new HashMap<>();

    public static String getPluginMessageResponse(String key) {
        return messages.get(key);
    }
    public static void setPluginMessageResponse(String key, String response) {
        messages.put(key, response);
        return;
    }
}
