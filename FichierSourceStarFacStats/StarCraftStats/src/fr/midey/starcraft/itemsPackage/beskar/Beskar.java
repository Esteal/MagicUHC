package fr.midey.starcraft.itemsPackage.beskar;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import fr.midey.starcraft.itemsPackage.ItemsConstructor;

public class Beskar implements Listener{
	
	ItemsConstructor morceauBeskar = new ItemsConstructor(Material.IRON_INGOT);
	ItemsConstructor beskar = new ItemsConstructor(Material.IRON_BLOCK);
	final ItemStack morceauBeskars;
	final ItemStack beskars;
	
	public Beskar() {
		morceauBeskar.applyName("§bMorceau de Beskar");
		morceauBeskar.applyLore("§4Métal très résistant mais le lingot est incomplet");
		
		beskar.applyName("§bBeskar");
		beskar.applyLore("§4Métal mandalorien possédant");
		beskar.applyLore("§4la plus grande résistance de la galaxie");
		beskar.applyEnchant(Enchantment.DIG_SPEED, 0);
		morceauBeskar.applyEnchant(Enchantment.DIG_SPEED, 0);
		
		this.beskars = morceauBeskar.getItem();
		this.morceauBeskars = morceauBeskar.getItem();
	}
	
	public void craftMorceauDeBeskar() {
		
		ShapedRecipe beskarRecipe = new ShapedRecipe(morceauBeskar.getItem());
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

		ShapedRecipe beskarRecipe = new ShapedRecipe(beskar.getItem());
		Material name = morceauBeskar.getItem().getType();
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
	
	@EventHandler
	public void craftNotBeskar(CraftItemEvent e) {
		ItemStack it = e.getCurrentItem();
		if(it.hasItemMeta() == false) return;
		String name = it.getItemMeta().getDisplayName();
		if(name.equalsIgnoreCase("§bBeskar")) {
			CraftingInventory inventory = e.getInventory();
			ItemMeta morceauMeta = morceauBeskars.getItemMeta();
			for(ItemStack items : inventory.getContents()) {
				if(items == null) continue;
				if(items.hasItemMeta() == false) {
					if(items.getType() == Material.IRON_INGOT) {
						e.getWhoClicked().sendMessage("Vous devez utiliser des §bMorceaux de Bescar§r pour pouvoir craft cet item !");
						e.setCancelled(true);
						break;
					}
					continue;
				}
				if(items.getType() == Material.IRON_BLOCK) continue;
				ItemMeta meta = items.getItemMeta();
				if(meta.getLore().get(0).equalsIgnoreCase(morceauMeta.getLore().get(0))) {
					if(meta.getDisplayName().equalsIgnoreCase(morceauMeta.getDisplayName())) {
						if(meta.getEnchants().equals(morceauMeta.getEnchants())) {
							continue;
						}
					}	
				}
				e.setCancelled(true);
			}
		}
	}
}
