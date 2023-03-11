package fr.midey.starcraft.itemsPackage.beskar;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class BeskarArmor {

	private BeskarLib beskarLib;
	ItemStack beskar;
	ItemStack helmetBeskar;
	ItemStack chestplateBeskar;
	ItemStack leggingsBeskar;
	ItemStack bootsBeskar;
	
	public BeskarArmor() {
		this.beskarLib = new BeskarLib();
		this.beskar = beskarLib.beskars;
		this.helmetBeskar = beskarLib.helmetBeskars;
		this.chestplateBeskar = beskarLib.chestplateBeskars;
		this.leggingsBeskar = beskarLib.leggingsBeskars;
		this.bootsBeskar = beskarLib.bootsBeskars;
	}
	
	public void craftBeskarHelmet() {

		ShapedRecipe beskarHelmetRecipe = new ShapedRecipe(helmetBeskar);
		Material name = beskar.getType();
		beskarHelmetRecipe.shape(
				"987",
				"654");
		beskarHelmetRecipe.setIngredient('9', name);
		beskarHelmetRecipe.setIngredient('8', name);
		beskarHelmetRecipe.setIngredient('7', name);
		beskarHelmetRecipe.setIngredient('6', name);
		beskarHelmetRecipe.setIngredient('4', name);
		Bukkit.addRecipe(beskarHelmetRecipe);
	}
	
	public void craftBeskarChestplate() {

		ShapedRecipe beskarChestplateRecipe = new ShapedRecipe(chestplateBeskar);
		Material name = beskar.getType();
		beskarChestplateRecipe.shape(
				"987",
				"654",
				"321");
		beskarChestplateRecipe.setIngredient('9', name);
		beskarChestplateRecipe.setIngredient('7', name);
		beskarChestplateRecipe.setIngredient('6', name);
		beskarChestplateRecipe.setIngredient('5', name);
		beskarChestplateRecipe.setIngredient('4', name);
		beskarChestplateRecipe.setIngredient('3', name);
		beskarChestplateRecipe.setIngredient('2', name);
		beskarChestplateRecipe.setIngredient('1', name);
		Bukkit.addRecipe(beskarChestplateRecipe);
	}
	
	public void craftBeskarLeggings() {

		ShapedRecipe beskarLeggingsRecipe = new ShapedRecipe(leggingsBeskar);
		Material name = beskar.getType();
		beskarLeggingsRecipe.shape(
				"987",
				"654",
				"321");
		beskarLeggingsRecipe.setIngredient('9', name);
		beskarLeggingsRecipe.setIngredient('8', name);
		beskarLeggingsRecipe.setIngredient('7', name);
		beskarLeggingsRecipe.setIngredient('6', name);
		beskarLeggingsRecipe.setIngredient('4', name);
		beskarLeggingsRecipe.setIngredient('3', name);
		beskarLeggingsRecipe.setIngredient('1', name);
		Bukkit.addRecipe(beskarLeggingsRecipe);
	}
	
	public void craftBeskarBoots() {

		ShapedRecipe beskarBootsRecipe = new ShapedRecipe(bootsBeskar);
		Material name = beskar.getType();
		beskarBootsRecipe.shape(
				"987",
				"654");
		beskarBootsRecipe.setIngredient('9', name);
		beskarBootsRecipe.setIngredient('7', name);
		beskarBootsRecipe.setIngredient('6', name);
		beskarBootsRecipe.setIngredient('4', name);
		Bukkit.addRecipe(beskarBootsRecipe);
	}
}
