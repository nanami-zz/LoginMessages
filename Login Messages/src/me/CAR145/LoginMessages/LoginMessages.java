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
			if (commandName.equalsIgnoreCase("Rules")) {
				if (split.length == 0) {
					player.sendMessage(ChatColor.GOLD + "Server Rules: " + rules1);
					player.sendMessage(ChatColor.GOLD + rules2);
					player.sendMessage(ChatColor.GOLD + rules3);
					player.sendMessage(ChatColor.GOLD + rules4);
				}

			}
		}
		return false;
	}

	public void loadConfig()
	{
		Configuration config = getConfiguration();
		config.load();


		rules1 = config.getString("rules-line-1", " <Replace with server rules> ");
		rules2 = config.getString("rules-line-2", " <replace with rules line 2> ");
		rules3 = config.getString("rules-line-3", " <replace with rules line 3> ");
		rules4 = config.getString("rules-line-4", " <replace with rules line 4> ");

                config.setProperty("rules-line-1", rules1);
                config.setProperty("rules-line-2", rules2);
                config.setProperty("rules-line-3", rules3);
                config.setProperty("rules-line-4", rules4);

		config.save();
	}






}