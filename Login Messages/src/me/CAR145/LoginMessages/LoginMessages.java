package me.CAR145.LoginMessages;

import java.util.logging.Logger;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;



public class LoginMessages extends JavaPlugin {
	public static LoginMessages plugin;

	public final Logger log = Logger.getLogger("Minecraft");
	private final LoginMessagesPlayerListener playerListener = new LoginMessagesPlayerListener(this);
	String rules1;
	String rules2;
	String rules3;
	String rules4;


	@Override
	public void onDisable() {
		this.log.info("Login Messages Disabled");

	}
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_JOIN, this.playerListener, Event.Priority.Normal, this);
		PluginDescriptionFile pdfFile = this.getDescription();
		this.log.info("[" + pdfFile.getName() + "]" + " Version " + pdfFile.getVersion() + " Is Enabled! ");
		loadConfig();
	}



	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		String[] split = args;
		String commandName = command.getName().toLowerCase();
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (commandName.equalsIgnoreCase("VIP")) {
				if (split.length == 0) {
					player.sendMessage(ChatColor.GOLD + "VIP");
                                        player.sendMessage(ChatColor.GOLD + GAVIMAS);
                                        player.sendMessage(ChatColor.GOLD + "VIP2");
                                        player.sendMessage(ChatColor.GOLD + "VIP3");
				}

			}
		}
		return false;
	}

	public void loadConfig()
	{
		Configuration config = getConfiguration();
		config.load();

                VIP = config.getString("VIP-line-1", " <Replace with something> ");
		GAVIMAS = config.getString("rules-line-1", " <Ka gauna> ");
                VIP2 = config.getString("VIP-line-2", " <Replace with something> ");
                VIP3 = config.getString("VIP-line-3", " <Replace with something> ");

                config.setProperty("VIP-line-1", VIP);
                config.setProperty("rules-line-1", GAVIMAS);
                config.setProperty("VIP-line-2", VIP2);
                config.setProperty("VIP-line-3", VIP3);

		config.save();
	}






}