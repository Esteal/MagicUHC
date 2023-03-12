package fr.midey.starcraft.itemsPackage.Saber;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import fr.midey.starcraft.itemsPackage.ItemsConstructor;
import fr.midey.starcraft.itemsPackage.ItemsCraftVerify;

public class CrystalKyber implements Listener{

	ItemStack crystalNeutre;
	public ItemStack crystalRed;
	public ItemStack crystalBlue;
	public ItemStack crystalGreen;
	public CrystalKyber() {
		
		ItemsConstructor crystalNeutre = new ItemsConstructor(Material.NETHER_STAR);
		crystalNeutre.applyName("§7Crystal kyber neutre");
		crystalNeutre.applyEnchant(Enchantment.DIG_SPEED, 0);
		this.crystalNeutre = crystalNeutre.getItem();
		
		ItemsConstructor crystalRed = new ItemsConstructor(Material.NETHER_STAR);
		crystalRed.applyName("§4Crystal kyber rouge");
		crystalRed.applyEnchant(Enchantment.DIG_SPEED, 0);
		this.crystalRed = crystalRed.getItem();
		
		ItemsConstructor crystalBlue = new ItemsConstructor(Material.NETHER_STAR);
		crystalBlue.applyName("§1Crystal kyber bleu");
		crystalBlue.applyEnchant(Enchantment.DIG_SPEED, 0);
		this.crystalBlue = crystalBlue.getItem();
		
		ItemsConstructor crystalGreen = new ItemsConstructor(Material.NETHER_STAR);
		crystalGreen.applyName("§2Crystal kyber vert");
		crystalGreen.applyEnchant(Enchantment.DIG_SPEED, 0);
		this.crystalGreen = crystalGreen.getItem();
	}
	
	public void craftCrystalNeutre() {
		ShapedRecipe crystal = new ShapedRecipe(crystalNeutre);
		crystal.shape(
				"080",
				"818",
				"080");
		crystal.setIngredient('8', Material.DIAMOND);
		crystal.setIngredient('1', Material.DIAMOND_BLOCK);
		Bukkit.addRecipe(crystal);
	}
	
	public void craftCrystal() {
		HashMap<ItemStack, Material> crystalColor = new HashMap<ItemStack, Material>();
		crystalColor.put(crystalBlue, Material.LAPIS_BLOCK);
		crystalColor.put(crystalRed, Material.REDSTONE_BLOCK);
		crystalColor.put(crystalGreen, Material.EMERALD_BLOCK);
		for (Entry<ItemStack, Material> color : crystalColor.entrySet()) {
			ShapedRecipe crystalColoured = new ShapedRecipe(color.getKey());
			crystalColoured.shape(
					"080",
					"818",
					"080");
			crystalColoured.setIngredient('8', color.getValue());
			crystalColoured.setIngredient('1', crystalNeutre.getType());
			Bukkit.addRecipe(crystalColoured);
		}
	}
	
	@EventHandler
	public void craft(PrepareItemCraftEvent e) {
		ItemsCraftVerify.craftVerify(e, crystalBlue, crystalNeutre);
		ItemsCraftVerify.craftVerify(e, crystalRed, crystalNeutre);
		ItemsCraftVerify.craftVerify(e, crystalGreen, crystalNeutre);

	}
}
