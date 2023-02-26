package fr.midey.starcraft.Spell;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

import fr.midey.starcraft.Stats;
import fr.midey.starcraft.formParticle.Circle;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class Guérison implements Listener {

	private Stats main;
	
	public Guérison(Stats main) {
		this.main = main;
	}
	
	@EventHandler
	public void onGuérison(PlayerInteractEvent e) {
		ItemStack it = e.getItem();
		if (it == null) return;
		if(it.getType() != Material.BARRIER) return;
		Action a = e.getAction();
		String itName = it.getItemMeta().getDisplayName();
		if(itName == null) return;
		if((itName.equalsIgnoreCase("§lGuérison")) && (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)) {
			Player p = e.getPlayer();
			if(main.getPlayerGrade().get(p.getUniqueId()).equalsIgnoreCase("Maître jedi")) {
				if(main.getCooldownGuérison().containsKey(p)) {
					p.sendMessage("Vous devez attendre §6" + main.getCooldownGuérison().get(p) + "§es§r avant de pouvoir utiliser cette compétence !");;
					return;
				}
				if(!p.getDisplayName().equalsIgnoreCase("Midey1901")) main.getCooldownGuérison().put(p, 60 * 5);
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*10,2));
				double vie = p.getHealth();
				if(vie + 4 <= 20) p.setHealth(vie + 4);
				else p.setHealth(20);
				BukkitTask task = Bukkit.getScheduler().runTaskTimer(main, new Runnable() {
					
					@Override
					public void run() {
						Location loc = p.getLocation();
						Circle circleOne = new Circle(loc, EnumParticle.CRIT_MAGIC, p, main, 1,"Guérison");
						circleOne.drawCircle();
						loc.setY(loc.getY() + 1);
						circleOne.changeLocation(loc);
						circleOne.drawCircle();
						loc.setY(loc.getY() + 1);
						circleOne.changeLocation(loc);
						circleOne.drawCircle();
					}
					
				}, 0, 0);
				
				Bukkit.getScheduler().runTaskLater(main, new Runnable() {
					
					@Override
					public void run() {
						task.cancel();
					}
					
				}, 20*10);
			}
		}
	}
}
