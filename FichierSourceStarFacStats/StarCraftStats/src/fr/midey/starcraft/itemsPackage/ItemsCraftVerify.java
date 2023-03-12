package fr.midey.starcraft.itemsPackage;

import org.bukkit.Material;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import fr.midey.starcraft.itemsPackage.Saber.CrystalKyber;
import fr.midey.starcraft.itemsPackage.Saber.LightSaber;

public class ItemsCraftVerify {
	
	public static void craftVerify(PrepareItemCraftEvent e, ItemStack resultCraft, ItemStack recipeItems) {
		Recipe recipe = e.getRecipe();
		if(recipe.getResult().isSimilar(resultCraft)) {
			CraftingInventory inv = e.getInventory();
			for (ItemStack items : inv.getContents()) {
				if(items == null) continue;
				if(!items.hasItemMeta()) {
					if(items.getType() == recipeItems.getType()) {
						inv.setResult(new ItemStack(Material.AIR));
						break;
					}
					continue;
				}
				if(items.getType() == resultCraft.getType()) continue;
				if(items.isSimilar(recipeItems)) continue;
				inv.setResult(new ItemStack(Material.AIR));
			}
		}
	}
	
	public static void craftVerifySameKyber(PrepareItemCraftEvent e, ItemStack resultCraft, ItemStack recipeItems) {
		Recipe recipe = e.getRecipe();
		if(recipe.getResult().isSimilar(resultCraft)) {
			CraftingInventory inv = e.getInventory();
			CrystalKyber crystal = new CrystalKyber();
			LightSaber saber = new LightSaber();
			for (ItemStack items : inv.getContents()) {
				if(items == null) continue;
				if(!items.hasItemMeta()) {
					if(items.getType().equals(recipeItems.getType())) {
						inv.setResult(new ItemStack(Material.AIR));
						break;
					}
					continue;
				}
				if(items.getType().equals(resultCraft.getType())) continue;
				if(items.isSimilar(crystal.crystalGreen)) {
					inv.setResult(saber.greenSaber.getItem());
					break;
				}
				if(items.isSimilar(crystal.crystalRed)) {
					inv.setResult(saber.redSaber.getItem());
					break;
				}
				if(items.isSimilar(crystal.crystalBlue)) {
					inv.setResult(saber.blueSaber.getItem());
					break;
				}
				inv.setResult(new ItemStack(Material.AIR));
			}
		}
	}
}
