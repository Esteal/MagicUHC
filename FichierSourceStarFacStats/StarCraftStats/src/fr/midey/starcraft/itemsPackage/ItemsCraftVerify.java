package fr.midey.starcraft.itemsPackage;

import org.bukkit.Material;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemsCraftVerify {

	public static void craftVerify(PrepareItemCraftEvent e, ItemStack resultCraft, ItemStack recipeItems) {
		Recipe recipe = e.getRecipe();
		if(recipe.getResult().isSimilar(resultCraft)) {
			CraftingInventory inv = e.getInventory();
			ItemMeta morceauMeta = recipeItems.getItemMeta();
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
				ItemMeta meta = items.getItemMeta();
				if(meta.getLore().get(0).equalsIgnoreCase(morceauMeta.getLore().get(0))) {
					if(meta.getDisplayName().equalsIgnoreCase(morceauMeta.getDisplayName())) {
						if(meta.getEnchants().equals(morceauMeta.getEnchants())) {
							continue;
						}
					}	
				}
				inv.setResult(new ItemStack(Material.AIR));
			}
		}
	}
}
