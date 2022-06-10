package me.permafreez;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.permafreez.Commands.Save;

public class Main extends JavaPlugin {

	public static JavaPlugin plugin;
	
	public static void addEvent(Listener l, Plugin pl) {
		pl.getServer().getPluginManager().registerEvents(l, pl);
	}
	
	public static void addCommand(String command, CommandExecutor executor) {
		plugin.getCommand(command).setExecutor(executor);
	}
	
	@Override
	public void onEnable() {
		plugin = this;
		
		addCommand("save", new Save());
	}
}
