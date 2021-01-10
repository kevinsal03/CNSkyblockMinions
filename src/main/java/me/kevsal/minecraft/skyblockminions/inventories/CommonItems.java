package me.kevsal.minecraft.skyblockminions.inventories;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Contains ItemStacks that might be reused by multiple inventories in the plugin
 */
public class CommonItems {

    public static ItemStack blankItem() {
        ItemStack item = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1);
        item.addUnsafeEnchantment(Enchantment.MENDING, 1);
        item.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(" ");
        item.setItemMeta(im);

        NBTItem nbtItem = new NBTItem(item);
        nbtItem.setBoolean("CNSBM_isNoClickItem", true);


        return nbtItem.getItem();
    }

}
