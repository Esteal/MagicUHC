package fr.midey.starcraft.statsManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.midey.starcraft.Stats;
import fr.midey.starcraft.itemsPackage.Saber.LightSaber;

public class StatsLoader implements Listener {

	private Stats main;
	LightSaber sabers = new LightSaber();
	List<ItemStack> saber = new ArrayList<>();

	public StatsLoader(Stats main) {
		this.main = main;
		saber.add(sabers.blueSaber.getItem());
		saber.add(sabers.redSaber.getItem());
		saber.add(sabers.greenSaber.getItem());
	}

	@EventHandler
	public void loadSpeed(PlayerMoveEvent e) {
		
		Player p = e.getPlayer();
		
		if(main.getCooldownStunt().containsKey(p) || main.getCooldownEtranglé().containsKey(p)) {
			p.setWalkSpeed(0);
			if(e.getFrom().getY() != e.getTo().getY()) e.setCancelled(true);
			return;
		}

		if(main.getCooldownVitesseSurhumaine().containsKey(p)) {
			if(main.getCooldownVitesseSurhumaine().get(p) > 20) {
				return;
			}
		}
				
		HashMap<Player, Location> locP = main.getPlayerLoc();
		if (!locP.containsKey(p)) locP.put(p, p.getLocation());
		if((p.getLocation().getBlockX() == locP.get(p).getBlockX()) && (p.getLocation().getBlockZ() == locP.get(p).getBlockZ())) return;
		locP.replace(p, p.getLocation());
		HashMap<Player, Float> speedP = main.getStatsControler().getSpeedPlayer();
		if((speedP.get(p) -0.2)*1000/3 <= 20) {
			speedP.replace(p, speedP.get(p) + 0.00005f);
		}
		else if ((speedP.get(p) -0.2)*1000/3 <= 25) {
			speedP.replace(p, speedP.get(p) + 0.000005f);
		}
		else if((speedP.get(p) -0.2)*1000/3 <= 30) {
			speedP.replace(p, speedP.get(p) + 0.0000005f);
		}
		else if((speedP.get(p) -0.2)*1000/3 <= 40) {
			speedP.replace(p, speedP.get(p) + 0.00000005f);
		}
		p.setWalkSpeed(speedP.get(p));
	}
	
	@EventHandler
	public void loadResistance(EntityDamageEvent e) {
		if(!(e.getEntity() instanceof Player)) return;
		double damage = e.getDamage();
		Player p = (Player)e.getEntity();
		if(main.getCooldownStunt().containsKey(p)) e.setCancelled(true);
		HashMap<Player, Float> resistanceP = main.getStatsControler().getResistancePlayer();
		if(resistanceP.get(p) * 100 <= 30) {
			resistanceP.replace(p, resistanceP.get(p) + 0.03f);
		}
		else if (resistanceP.get(p) * 100 <= 60) {
			resistanceP.replace(p, resistanceP.get(p) + 0.003f);
		}
		else if(resistanceP.get(p) * 100 <= 90) {
			resistanceP.replace(p, resistanceP.get(p) + 0.0003f);
		}
		else if(resistanceP.get(p) * 100 <= 100) {
			resistanceP.replace(p, resistanceP.get(p) + 0.00003f);
		}
		double reducedDamage = damage - damage * (main.getStatsControler().getResistancePlayer().get(p)/2);
		e.setDamage(reducedDamage);
	}
	
	@EventHandler
	public void loadForce(EntityDamageByEntityEvent e) {
		if(!(e.getDamager() instanceof Player)) return;
		double damage = e.getDamage();
		Player p = (Player) e.getDamager();
		if(saber.contains(p.getItemInHand())) {
			if (damage > 5) damage = 18;
			else damage = 15;
			for(PotionEffect effect : p.getActivePotionEffects()) {
				if (effect.getType().equals(PotionEffectType.INCREASE_DAMAGE)) {
					damage = 25;
					break;
				}
			}
		}
		double dDamage = damage + damage * main.getStatsControler().getForcePlayer().get(p);
		HashMap<Player, Float> forceP = main.getStatsControler().getForcePlayer();
		if(forceP.get(p) * 100 <= 30) {
			forceP.replace(p, forceP.get(p) + 0.01f);
		}
		else if (forceP.get(p) * 100 <= 60) {
			forceP.replace(p, forceP.get(p) + 0.001f);
		}
		else if(forceP.get(p) * 100 <= 90) {
			forceP.replace(p, forceP.get(p) + 0.0001f);
		}
		else if(forceP.get(p) * 100 <= 100) {
			forceP.replace(p, forceP.get(p) + 0.00001f);
		}
		e.setDamage(dDamage);
	}
}
