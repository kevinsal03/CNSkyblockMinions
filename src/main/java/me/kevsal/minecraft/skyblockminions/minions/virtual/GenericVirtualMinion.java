package me.kevsal.minecraft.skyblockminions.minions.virtual;

import me.kevsal.minecraft.skyblockminions.minions.MinionType;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.sql.Timestamp;
import java.util.UUID;

public class GenericVirtualMinion extends AbstractVirtualMinion {
    public GenericVirtualMinion(int minionID, UUID ownerUUID, String minionName, MinionType type, boolean spawned, Location location, Timestamp lastUpdated) {
        super(minionID, ownerUUID, minionName, type, spawned, location, lastUpdated);
    }

    @Override
    protected void updateMinionContents() {
        // Update its inv
        Bukkit.getServer().broadcastMessage("THE MINION TRIED TO UPDATE ITS CONTENTS");
    }
}
