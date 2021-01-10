package me.kevsal.minecraft.skyblockminions.inventories;

import lombok.Getter;
import me.kevsal.minecraft.skyblockminions.minions.Minion;
import me.kevsal.minecraft.skyblockminions.minions.virtual.AbstractVirtualMinion;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class MinionInventory {

    @Getter private final Inventory bukkitInventory;
    @Getter private final Minion minion;

    public MinionInventory(AbstractVirtualMinion minion, int size) {
        // Add one more row onto the size created to add the buttons
        bukkitInventory = Bukkit.createInventory(minion, size + 9, minion.getMinionName() + "'s Inventory");
        this.minion = minion;
        setupInventoryButtons();
    }

    private void setupInventoryButtons() {
        int firstSlot = bukkitInventory.getSize() - 9; // No need to -1 because indexed at 0
        for (int i = firstSlot; i < bukkitInventory.getSize(); i++) {
            bukkitInventory.setItem(i, CommonItems.blankItem());
        }
    }

}
