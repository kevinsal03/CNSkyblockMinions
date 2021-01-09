package me.kevsal.minecraft.skyblockminions.minions;

import me.kevsal.minecraft.skyblockminions.minions.virtual.AbstractVirtualMinion;
import org.bukkit.OfflinePlayer;

import java.util.UUID;

public interface AbstractMinion {

    /**
     * Get the Minion ID
     * @return int minionID equal to database ID
     */
    int getMinionID();

    OfflinePlayer getOwner();

    /**
     * Get the type of minion
     * @return enum MinionType type
     */
    MinionType getType();

    /**
     * The AbstractVirtualMinion instance of this minion
     * @return AbstractVirtualMinion of this minion
     */
    AbstractVirtualMinion getVirtualMinion();
}
