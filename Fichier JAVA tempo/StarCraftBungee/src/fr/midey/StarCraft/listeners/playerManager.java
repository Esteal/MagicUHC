package fr.midey.StarCraft.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.midey.StarCraft.Main;
import fr.midey.StarCraft.items.constructorItem;

public class playerManager implements Listener {

	private Main main;
	
	public playerManager(Main main) {
		this.main = main;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		main.saveDefaultConfig();
		Player p = e.getPlayer();
		constructorItem item = new constructorItem(Material.COMPASS);
		item.applyName("MENU");
		p.getInventory().setItem(4, item.getItem());
	}
}
