package fr.midey.starcraft.playerManager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import fr.midey.starcraft.Stats;
import fr.midey.starcraft.itemsPackage.ItemWand;
import fr.midey.starcraft.itemsPackage.Saber.LightSaber;
import fr.midey.starcraft.itemsPackage.beskar.BeskarLib;

public class onRespawnPlayer implements Listener {

	private Stats main;
	
	public onRespawnPlayer(Stats main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		p.getInventory().clear();
		ItemStack barrier = new ItemWand(main).getWand();
		LightSaber saber = new LightSaber();
		BeskarLib armor = new BeskarLib();
		p.getInventory().setBoots(armor.bootsBeskars);
		p.getInventory().setChestplate(armor.chestplateBeskars);
		p.getInventory().setLeggings(armor.leggingsBeskars);
		p.getInventory().setHelmet(armor.helmetBeskars);
		p.getInventory().addItem(saber.greenSaber.getItem());
		p.getInventory().addItem(barrier);
		p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 64));
		
		Potion potions = new Potion(PotionType.INSTANT_HEAL, 2);
		potions.setSplash(true);
		for(int i = 0; i < 34; i++) {
			p.getInventory().addItem(potions.toItemStack(1));
		}
	}
}
