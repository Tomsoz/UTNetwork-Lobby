package tk.utnetwork.utnetworklobby;

import org.bukkit.plugin.java.JavaPlugin;
import tk.utnetwork.utnetworklobby.Utils.Utils;

public final class UTNetworkLobby extends JavaPlugin {

    @Override
    public void onEnable() {
        Utils.log("&aSuccessfully enabled UTNetwork-Lobby.");

    }

    @Override
    public void onDisable() {
        Utils.log("&aSuccessfully disabled UTNetwork-Lobby.");
    }
}
