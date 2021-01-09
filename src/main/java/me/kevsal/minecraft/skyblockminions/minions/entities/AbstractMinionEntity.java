package me.kevsal.minecraft.skyblockminions.minions.entities;

import lombok.Getter;
import me.kevsal.minecraft.skyblockminions.minions.AbstractMinion;
import me.kevsal.minecraft.skyblockminions.minions.MinionType;
import me.kevsal.minecraft.skyblockminions.minions.virtual.AbstractVirtualMinion;
import org.bukkit.OfflinePlayer;

public abstract class AbstractMinionEntity implements AbstractMinion {

    /**
     * The minion ID.
     */
    @Getter private final int minionID;

    /**
     * The minion's owner.
     */
    @Getter private final OfflinePlayer owner;

    /**
     * The type of minion
     */

    @Getter private final MinionType type;

    /**
     * The original virtual minion object
     */
    @Getter private final AbstractVirtualMinion virtualMinion;

    public AbstractMinionEntity(AbstractVirtualMinion virtualMinion) {
        this.virtualMinion = virtualMinion;
        this.minionID = virtualMinion.getMinionID();
        this.type = virtualMinion.getType();
        this.owner = virtualMinion.getOwner();
    }

    abstract void performVisualAction();

}
