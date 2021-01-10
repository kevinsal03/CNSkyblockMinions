package me.kevsal.minecraft.skyblockminions.minions.virtual;

import lombok.Getter;
import lombok.Setter;
import me.kevsal.minecraft.skyblockminions.SkyblockMinions;
import me.kevsal.minecraft.skyblockminions.inventories.MinionInventory;
import me.kevsal.minecraft.skyblockminions.minions.Minion;
import me.kevsal.minecraft.skyblockminions.minions.MinionType;
import me.kevsal.minecraft.skyblockminions.storage.DatabaseManager;
import me.kevsal.minecraft.skyblockminions.utilities.InventoryConverter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.h2.tools.SimpleResultSet;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

public abstract class AbstractVirtualMinion implements Minion, InventoryHolder {


    @Getter private final int minionID;
    @Getter private final OfflinePlayer owner;
    @Getter @Setter private String minionName;
    @Getter private final MinionType type;
    @Getter @Setter private boolean spawned;
    @Getter @Setter private Location location;
    @Getter @Setter private Timestamp lastUpdated;

    private MinionInventory inventory;

    public AbstractVirtualMinion(int minionID, UUID ownerUUID, String minionName, MinionType type, boolean spawned, Location location, Timestamp lastUpdated) {
        this.minionID = minionID;
        owner = Bukkit.getOfflinePlayer(ownerUUID);
        this.minionName = minionName;
        this.type = type;
        this.spawned = spawned;
        this.location = location;
        this.lastUpdated = lastUpdated;

        inventory = new MinionInventory(this, 9);
    }

    @Override
    public AbstractVirtualMinion getVirtualMinion() {
       return this;
    }

    @Override
    public ResultSet getDatabaseMinion() {
        try {
            return DatabaseManager.getDatabase().prepareStatement("SELECT 1 FROM MINION_ENTITIES WHERE ID = " + minionID).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            SkyblockMinions.getInstance().getSLF4JLogger().warn("Failed to get DB minion with Minion ID \"" + minionID + "\". DB is probably corrupted.");
            return new SimpleResultSet(); // Give something so lower methods get SQLException rather than NPE
        }
    }

    /**
     * Get + update the inventory of the minion
     * @return org.bukkit.inventory.Inventory populated with the contents of this minion
     */
    public @NotNull Inventory getInventory() {
        updateMinionContents();
        return inventory.getBukkitInventory();
    }
    /**
     * Get + update the inventory of the minion as a MinionInventory
     * @return MinionInventory for this minion
     */
    public @NotNull MinionInventory getMinionInventory() {
        updateMinionContents();
        return inventory;
    }

    /**
     * Updates the internal Inventory inventory to be from the DB, doesn't update content
     */
    protected void updateInventoryFromDB() {
        try {
            inventory = (MinionInventory) InventoryConverter.jsonToInventory(getDatabaseMinion().getString(10));
        } catch (SQLException e) {
            SkyblockMinions.getInstance().getSLF4JLogger().warn("Failed to get INV from DB with Minion ID \"" + minionID + "\". DB is probably corrupted.");
        }
    }

    protected void commitInventoryToDB() {

    }

    /**
     *
     */
    public void updateMinion() {
        updateMinionContents();
        commitInventoryToDB();
    }

    /**
     * Actually update the minion's inventory
     */
    protected abstract void updateMinionContents();
}
