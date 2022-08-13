package tk.utnetwork.utnetworklobby.Utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import tk.utnetwork.utnetworklobby.UTNetworkLobby;

import java.util.HashMap;

public class Utils {

    static UTNetworkLobby plugin;

    public Utils(UTNetworkLobby plugin) {
        this.plugin = plugin;
    }

    public static String chat(String textToTranslate) {
        return (plugin.getConfig().getString("prefix") + textToTranslate)
                .replaceAll("%p", getPrimaryColour())
                .replaceAll("%s", getSecondaryColour())
                .replaceAll("%t", getTertiaryColour())
                .replaceAll("&", "§");
    }
    public static String chatRaw(String textToTranslate) {
        return textToTranslate
                .replaceAll("%p", getPrimaryColour())
                .replaceAll("%s", getSecondaryColour())
                .replaceAll("%t", getTertiaryColour())
                .replaceAll("&", "§");
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

    public static String getPrimaryColour() {
        return plugin.getConfig().getString("colors.primary") == null ?
                "&3" : plugin.getConfig().getString("colors.primary");
    }
    public static String getSecondaryColour() {
        return plugin.getConfig().getString("colors.secondary") == null ?
                "&b" : plugin.getConfig().getString("colors.secondary");
    }
    public static String getTertiaryColour() {
        return plugin.getConfig().getString("colors.tertiary") == null ?
                "&c" : plugin.getConfig().getString("colors.tertiary");
    }

    public static String formatTime(int secs) {
        int remainder = secs % 86400;

        int days 	= secs / 86400;
        int hours 	= remainder / 3600;
        int minutes	= (remainder / 60) - (hours * 60);
        int seconds	= (remainder % 3600) - (minutes * 60);

        String fDays 	= (days > 0 	? " " + days + " day" 		+ (days > 1 ? "s" : "") 	: "");
        String fHours 	= (hours > 0 	? " " + hours + " hour" 	+ (hours > 1 ? "s" : "") 	: "");
        String fMinutes = (minutes > 0 	? " " + minutes + " minute"	+ (minutes > 1 ? "s" : "") 	: "");
        String fSeconds = (seconds > 0 	? " " + seconds + " second"	+ (seconds > 1 ? "s" : "") 	: "");

        return new StringBuilder().append(fDays).append(fHours)
                .append(fMinutes).append(fSeconds).toString();
    }
}
