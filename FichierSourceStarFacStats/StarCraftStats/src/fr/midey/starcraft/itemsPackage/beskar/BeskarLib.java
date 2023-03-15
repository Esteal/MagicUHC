package fr.midey.starcraft.itemsPackage.beskar;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import fr.midey.starcraft.itemsPackage.ItemsConstructor;
import fr.midey.starcraft.itemsPackage.ItemsCraftVerify;

public class BeskarLib implements Listener{

	ItemsConstructor morceauBeskar = new ItemsConstructor(Material.IRON_INGOT);
	ItemsConstructor beskar = new ItemsConstructor(Material.IRON_BLOCK);
	ItemsConstructor helmetBeskar = new ItemsConstructor(Material.DIAMOND_HELMET);
	ItemsConstructor chestplateBeskar = new ItemsConstructor(Material.DIAMOND_CHESTPLATE);
	ItemsConstructor leggingsBeskar = new ItemsConstructor(Material.DIAMOND_LEGGINGS);
	ItemsConstructor bootsBeskar = new ItemsConstructor(Material.DIAMOND_BOOTS);

	
	final ItemStack morceauBeskars;
	final ItemStack beskars;
	public final ItemStack helmetBeskars;
	public final ItemStack chestplateBeskars;
	public final ItemStack leggingsBeskars;
	public final ItemStack bootsBeskars;
	
	public BeskarLib() {
		
		morceauBeskar.applyName("�bMorceau de Beskar");
		morceauBeskar.applyLore("�4M�tal tr�s r�sistant mais le lingot est incomplet");
		morceauBeskar.applyEnchant(Enchantment.DIG_SPEED, 0);

		beskar.applyName("�bBeskar");
		beskar.applyLore("�4M�tal mandalorien poss�dant");
		beskar.applyLore("�4la plus grande r�sistance de la galaxie");
		beskar.applyEnchant(Enchantment.DIG_SPEED, 0);

		helmetBeskar.applyName("�bCasque en Beskar");
		helmetBeskar.applyLore("�4Casque compos� du m�tal mandalorien poss�dant");
		helmetBeskar.applyLore("�4la plus grande r�sistance de la galaxie");
		helmetBeskar.applyEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		helmetBeskar.applyUmbreakable(true);

		chestplateBeskar.applyName("�bPlastron en Beskar");
		chestplateBeskar.applyLore("�4Plastron compos� du m�tal mandalorien poss�dant");
		chestplateBeskar.applyLore("�4la plus grande r�sistance de la galaxie");
		chestplateBeskar.applyEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		chestplateBeskar.applyUmbreakable(true);

		leggingsBeskar.applyName("�bJambi�res en Beskar");
		leggingsBeskar.applyLore("�4Jambi�res compos� du m�tal mandalorien poss�dant");
		leggingsBeskar.applyLore("�4la plus grande r�sistance de la galaxie");
		leggingsBeskar.applyEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		leggingsBeskar.applyUmbreakable(true);
		
		bootsBeskar.applyName("�bBottes en Beskar");
		bootsBeskar.applyLore("�4Bottes compos� du m�tal mandalorien poss�dant");
		bootsBeskar.applyLore("�4la plus grande r�sistance de la galaxie");
		bootsBeskar.applyEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		bootsBeskar.applyUmbreakable(true);
		
		this.beskars = beskar.getItem();
		this.morceauBeskars = morceauBeskar.getItem();
		this.helmetBeskars = helmetBeskar.getItem();
		this.chestplateBeskars = chestplateBeskar.getItem();
		this.leggingsBeskars = leggingsBeskar.getItem();
		this.bootsBeskars = bootsBeskar.getItem();


		
	}
	
	@EventHandler
	public void craftRecipe(PrepareItemCraftEvent e) {
		ItemsCraftVerify.craftVerify(e, beskars, morceauBeskars);
		ItemsCraftVerify.craftVerify(e, helmetBeskars, beskars);
		ItemsCraftVerify.craftVerify(e, chestplateBeskars, beskars);
		ItemsCraftVerify.craftVerify(e, leggingsBeskars, beskars);
		ItemsCraftVerify.craftVerify(e, bootsBeskars, beskars);
	}
}
