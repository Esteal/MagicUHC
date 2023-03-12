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

public class LightSaber implements Listener{

	public ItemsConstructor redSaber = new ItemsConstructor(Material.DIAMOND_SWORD);
	public ItemsConstructor greenSaber = new ItemsConstructor(Material.WOOD_SWORD);
	public ItemsConstructor blueSaber = new ItemsConstructor(Material.IRON_SWORD);
	CrystalKyber crystal = new CrystalKyber();
	
	public LightSaber() {
		redSaber.applyName("§4Sabre laser");
		redSaber.applyLore("§9+14 attack damage");
		redSaber.applyEnchant(Enchantment.DAMAGE_ALL, 0);
		redSaber.applyUmbreakable(true);
		
		greenSaber.applyName("§2Sabre laser");
		greenSaber.applyLore("§9+14 attack damage");
		greenSaber.applyEnchant(Enchantment.DAMAGE_ALL, 3);
		greenSaber.applyUmbreakable(true);
		
		blueSaber.applyName("§1Sabre laser");
		blueSaber.applyLore("§9+14 attack damage");
		blueSaber.applyEnchant(Enchantment.DAMAGE_ALL, 1);
		blueSaber.applyUmbreakable(true);

	}

	public void craftSaber() {
		
		HashMap<ItemStack, ItemStack> sabers = new HashMap<ItemStack, ItemStack>();
		sabers.put(blueSaber.getItem(), crystal.crystalBlue);
		sabers.put(greenSaber.getItem(), crystal.crystalGreen);
		sabers.put(redSaber.getItem(), crystal.crystalRed);
		for(Entry<ItemStack, ItemStack> saber : sabers.entrySet()) {
			ShapedRecipe saberRecipes = new ShapedRecipe(saber.getKey());
			Material name = saber.getValue().getType();
			saberRecipes.shape(
					"9",
					"6",
					"3");
			saberRecipes.setIngredient('9', name);
			saberRecipes.setIngredient('6', name);
			saberRecipes.setIngredient('3', Material.STICK);
			Bukkit.addRecipe(saberRecipes);
		}
	}
	
	@EventHandler
	public void craftSword(PrepareItemCraftEvent e) {
		ItemsCraftVerify.craftVerifySameKyber(e, greenSaber.getItem(), crystal.crystalGreen);
		ItemsCraftVerify.craftVerifySameKyber(e, blueSaber.getItem(), crystal.crystalBlue);
		ItemsCraftVerify.craftVerifySameKyber(e, redSaber.getItem(), crystal.crystalRed);

	}
}
