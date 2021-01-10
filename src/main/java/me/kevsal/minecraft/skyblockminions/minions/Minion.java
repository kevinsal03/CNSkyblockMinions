package me.kevsal.minecraft.skyblockminions.minions;

import me.kevsal.minecraft.skyblockminions.minions.virtual.AbstractVirtualMinion;
import org.bukkit.OfflinePlayer;

import java.sql.ResultSet;
import java.util.UUID;

public interface Minion {

    /**
     * Get the Minion ID
     * @return int minionID equal to database ID
     */
    int getMinionID();

    /**
     * The owner of this minion
     * @return org.bukkit.OfflinePlayer grabbed from the OwnerUUID in the database
     */
    OfflinePlayer getOwner();

    /**
     * Get the type of minion
     * @return enum MinionType type
     */
    MinionType getType();

    /**
     * Grabs the database entry that the current Minion represents
     * @return a SQL ResultSet containing SQL version of this Minion.
     */
    ResultSet getDatabaseMinion();

    /**
     * The AbstractVirtualMinion instance of this minion
     * @return AbstractVirtualMinion of this minion
     */
    AbstractVirtualMinion getVirtualMinion();
}
