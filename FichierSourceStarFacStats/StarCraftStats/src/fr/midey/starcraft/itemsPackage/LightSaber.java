package fr.midey.starcraft.itemsPackage;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class LightSaber implements Listener{

	ItemsConstructor redSaber = new ItemsConstructor(Material.DIAMOND_SWORD);
	ItemsConstructor redMaterial = new ItemsConstructor(Material.NETHER_STAR);
	ItemsConstructor greenSaber = new ItemsConstructor(Material.STONE_SWORD);

	private HashMap<ItemStack, ItemStack> sabers = new HashMap<ItemStack, ItemStack>();

	public LightSaber() {
		redSaber.applyName("§9Sabre laser");
		redMaterial.applyName("§9Crystal kyber rouge sang");
		sabers.put(redSaber.getItem(), redMaterial.getItem());
	}

	public void craftRedSaber() {

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
		CraftingInventory inv = e.getInventory();
		if(inv.getResult().getType() == Material.DIAMOND_SWORD) {
			if(!inv.contains(new ItemStack(Material.NETHER_STAR))) inv.setResult(new ItemStack(Material.AIR));
		}
	}
}
