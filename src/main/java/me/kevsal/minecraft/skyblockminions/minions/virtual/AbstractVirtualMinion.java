package me.kevsal.minecraft.skyblockminions.minions.virtual;

import lombok.Getter;
import lombok.Setter;
import me.kevsal.minecraft.skyblockminions.minions.AbstractMinion;
import me.kevsal.minecraft.skyblockminions.minions.MinionType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.Inventory;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.UUID;

public abstract class AbstractVirtualMinion implements AbstractMinion {


    @Getter private final int minionID;
    @Getter private final OfflinePlayer owner;
    @Getter @Setter private String minionName;
    @Getter private final MinionType type;
    @Getter @Setter private boolean spawned;
    @Getter @Setter private Location location;
    @Getter private final Inventory inventory;
    @Getter private final HashMap<String, ?> options;
    @Getter @Setter private Timestamp lastUpdated;



    public AbstractVirtualMinion(int minionID, UUID ownerUUID, String minionName, MinionType type, boolean spawned, Location location, Inventory inventory, HashMap<String, ?> options, Timestamp lastUpdated) {
        this.minionID = minionID;
        owner = Bukkit.getOfflinePlayer(ownerUUID);
        this.minionName = minionName;
        this.type = type;
        this.spawned = spawned;
        this.location = location;
        this.inventory = inventory;
        this.options = options;
        this.lastUpdated = lastUpdated;
    }

    @Override
    public AbstractVirtualMinion getVirtualMinion() {
       return this;
    }

    abstract void updateMinionContents();
}
