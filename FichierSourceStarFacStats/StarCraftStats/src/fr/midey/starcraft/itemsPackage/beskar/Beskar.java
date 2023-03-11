package fr.midey.starcraft.itemsPackage.beskar;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Beskar {
	
	private BeskarLib beskarLib;
	ItemStack beskar;
	ItemStack morceauBeskar;
	
	public Beskar() {
		this.beskarLib = new BeskarLib();
		this.beskar = beskarLib.beskars;
		this.morceauBeskar = beskarLib.morceauBeskars;
	}
	
	public void craftMorceauDeBeskar() {
		
		ShapedRecipe beskarRecipe = new ShapedRecipe(morceauBeskar);
		beskarRecipe.shape(
				"987",
				"654",
				"321");
		beskarRecipe.setIngredient('9', Material.IRON_INGOT);
		beskarRecipe.setIngredient('8', Material.IRON_INGOT);
		beskarRecipe.setIngredient('7', Material.IRON_INGOT);
		beskarRecipe.setIngredient('6', Material.IRON_INGOT);
		beskarRecipe.setIngredient('5', Material.IRON_BLOCK);
		beskarRecipe.setIngredient('4', Material.IRON_INGOT);
		beskarRecipe.setIngredient('3', Material.IRON_INGOT);
		beskarRecipe.setIngredient('2', Material.IRON_INGOT);
		beskarRecipe.setIngredient('1', Material.IRON_INGOT);
		Bukkit.addRecipe(beskarRecipe);
		
	}
	
	public void craftBeskar() {

		ShapedRecipe beskarRecipe = new ShapedRecipe(beskar);
		Material name = morceauBeskar.getType();
		beskarRecipe.shape(
				"987",
				"654",
				"321");
		beskarRecipe.setIngredient('8', name);
		beskarRecipe.setIngredient('6', name);
		beskarRecipe.setIngredient('5', name);
		beskarRecipe.setIngredient('4', name);
		beskarRecipe.setIngredient('2', name);
		Bukkit.addRecipe(beskarRecipe);
	}
}
