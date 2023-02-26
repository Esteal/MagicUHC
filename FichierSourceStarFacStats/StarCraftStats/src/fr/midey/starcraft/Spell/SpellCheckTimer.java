package fr.midey.starcraft.Spell;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.midey.starcraft.Stats;

public class SpellCheckTimer extends BukkitRunnable{

	private Stats main;
	
	
	public SpellCheckTimer(Stats main) {
		this.main = main;
	}

	@Override
	public void run() {
		ArrayList<HashMap<Player, Integer>> listHashMap = new ArrayList<HashMap<Player, Integer>>();
		listHashMap.add(main.getCooldownAttraction());
		listHashMap.add(main.getCooldownRepulsion());
		listHashMap.add(main.getCooldownVitesseSurhumaine());
		listHashMap.add(main.getCooldownEtranglement());
		listHashMap.add(main.getCooldownEtranglé());
		listHashMap.add(main.getCooldownEclairs());
		listHashMap.add(main.getCooldownDrainDeVie());
		listHashMap.add(main.getCooldownStunt());
		listHashMap.add(main.getCooldownVie());
		listHashMap.add(main.getCooldownBouclier());
		listHashMap.add(main.getCooldownSabre());
		listHashMap.add(main.getCooldownGuérison());
		listHashMap.add(main.getCooldownRage());
		for(Player p : Bukkit.getOnlinePlayers()) {
			for(HashMap<Player, Integer> h : listHashMap) {
				checkHashMapPlayer(p, h);
			}
		}
	}
	
	public void checkHashMapPlayer(Player p, HashMap<Player, Integer> h) {
		if(h.containsKey(p)) {
			Integer cd = h.get(p);
			h.replace(p, cd - 1);
			if(cd <= 0 ) {
				if(h == main.getCooldownVie()) p.setHealthScale(20);
				if(h == main.getCooldownStunt()) p.setWalkSpeed(main.getStatsControler().getSpeedPlayer().get(p));
				h.remove(p);
			}
		}
	}
}
