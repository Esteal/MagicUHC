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

public class Rage implements Listener {

	private Stats main;
	
	public Rage(Stats main) {
		this.main = main;
	}
	
	@EventHandler
	public void onRage(PlayerInteractEvent e) {
		ItemStack it = e.getItem();
		if (it == null) return;
		if(it.getType() != Material.BARRIER) return;
		Action a = e.getAction();
		String itName = it.getItemMeta().getDisplayName();
		if(itName == null) return;
		if((itName.equalsIgnoreCase("§lRage")) && (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK)) {
			Player p = e.getPlayer();
			if(main.getPlayerGrade().get(p.getUniqueId()).equalsIgnoreCase("Seigneur sith")) {
				if(main.getCooldownRage().containsKey(p)) {
					p.sendMessage("Vous devez attendre §6" + main.getCooldownRage().get(p) + "§es§r avant de pouvoir utiliser cette compétence !");;
					return;
				}
				if(!p.getDisplayName().equalsIgnoreCase("Midey1901")) main.getCooldownRage().put(p, 60 * 5);
				
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*10,0));
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
						p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*15,3));
					}
					
				}, 20*10);
			}
		}
	}
}
