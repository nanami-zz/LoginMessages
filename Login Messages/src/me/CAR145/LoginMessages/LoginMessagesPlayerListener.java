package me.CAR145.LoginMessages;





import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class LoginMessagesPlayerListener extends PlayerListener{
	public static LoginMessages plugin;

	public LoginMessagesPlayerListener(LoginMessages instance) {
		plugin = instance;
	}

	@Override
	public void onPlayerJoin(PlayerJoinEvent event)
	{


		plugin.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "Rasyk /VIP norint suzinoti jo galimybes!" + event.getPlayer().getName();
	}


}
