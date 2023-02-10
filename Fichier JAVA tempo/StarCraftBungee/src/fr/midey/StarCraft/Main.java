package fr.midey.StarCraft;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.midey.StarCraft.listeners.playerManager;


public class Main extends JavaPlugin{

	public void  onEnable() {
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new playerManager(this), this);
	}
}
