package fr.midey.starcraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class onSpeedListener implements Listener {
	
	int i = 1;
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if(e.getItem() == null) return;
		Player p = e.getPlayer();
		if(e.getItem().getType() == Material.BONE) p.setWalkSpeed(0.2f);
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		int pt = 1;
		Player p = e.getPlayer();
		Bukkit.broadcastMessage("speed : " +p.getWalkSpeed());
		if (i == 1&& pt == 1) {
			i++;
			p.setWalkSpeed(p.getWalkSpeed() + 0.05f);
		}
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
			e.setDamage(e.getDamage() + e.getDamage() *0.2);
	}
}
