package tk.utnetwork.utnetworklobby.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Utils {

    public static String chat(String textToTranslate) {
        return ChatColor.translateAlternateColorCodes('&', textToTranslate);
    }

    public static void log(String logToExecute) {
        logToExecute = chat(logToExecute);
        Bukkit.getConsoleSender().sendMessage(logToExecute);
    }

}
