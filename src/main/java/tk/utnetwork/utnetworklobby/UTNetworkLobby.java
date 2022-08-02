package tk.utnetwork.utnetworklobby;

import org.bukkit.plugin.java.JavaPlugin;
import tk.utnetwork.utnetworklobby.Commands.ProfileCommand;
import tk.utnetwork.utnetworklobby.Commands.ServerSelectorCommand;
import tk.utnetwork.utnetworklobby.Events.*;
import tk.utnetwork.utnetworklobby.Utils.Utils;

public final class UTNetworkLobby extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new PluginMessage(this));

        getCommand("serverselector").setExecutor(new ServerSelectorCommand(this));
        getCommand("profile").setExecutor(new ProfileCommand());
        getServer().getPluginManager().registerEvents(new JoinAndQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new SelectInvEvent(), this);
        getServer().getPluginManager().registerEvents(new SelectEvent(this), this);

        Utils utils = new Utils(this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Utils.log("&aSuccessfully enabled UTNetwork-Lobby.");

    }

    @Override
    public void onDisable() {
        Utils.log("&aSuccessfully disabled UTNetwork-Lobby.");
    }
}
