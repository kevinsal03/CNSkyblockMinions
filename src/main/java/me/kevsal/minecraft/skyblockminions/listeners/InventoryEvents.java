package me.kevsal.minecraft.skyblockminions.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.kevsal.minecraft.skyblockminions.minions.Minion;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("unused")
public class InventoryEvents implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getInventory().getHolder() instanceof Minion) {
            ItemStack clickedItem = e.getCurrentItem();
            if ((clickedItem != null) && (clickedItem.getType() != Material.AIR)) {
                if (new NBTItem(clickedItem).getBoolean("CNSBM_isNoClickItem")) {
                    e.getWhoClicked().sendMessage("clicky click");
                    e.setCancelled(true);
                }
            }
        }
    }
}
