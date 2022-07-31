package tk.utnetwork.utnetworklobby.Events;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import tk.utnetwork.utnetworklobby.UTNetworkLobby;
import tk.utnetwork.utnetworklobby.Utils.Utils;

public class PluginMessage implements PluginMessageListener {
    UTNetworkLobby plugin;
    public PluginMessage(UTNetworkLobby plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onPluginMessageReceived(String channel, Player p, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();
        if (subchannel.equals("PlayerCount")) {
            String server = in.readUTF();
            int playercount = in.readInt();
            Utils.setPluginMessageResponse("PlayerCount__" + server, playercount + "");
        }
    }
}
