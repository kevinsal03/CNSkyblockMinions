package me.kevsal.minecraft.skyblockminions.minions.virtual;

import me.kevsal.minecraft.skyblockminions.minions.MinionType;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.UUID;

public class GenericVirtualMinion extends AbstractVirtualMinion {
    public GenericVirtualMinion(int minionID, UUID ownerUUID, String minionName, MinionType type, boolean spawned, Location location, Inventory inventory, HashMap<String, ?> options, Timestamp lastUpdated) {
        super(minionID, ownerUUID, minionName, type, spawned, location, inventory, options, lastUpdated);
    }

    @Override
    void updateMinionContents() {
        // Update its inv
    }
}
