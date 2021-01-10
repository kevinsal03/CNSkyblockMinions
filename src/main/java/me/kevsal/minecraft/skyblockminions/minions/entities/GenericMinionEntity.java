package me.kevsal.minecraft.skyblockminions.minions.entities;

import me.kevsal.minecraft.skyblockminions.minions.MinionType;
import me.kevsal.minecraft.skyblockminions.minions.virtual.AbstractVirtualMinion;

public class GenericMinionEntity extends AbstractMinionEntity {

    public GenericMinionEntity(AbstractVirtualMinion virtualMinion) {
        super(virtualMinion);
    }

    @Override
    public void performVisualAction() {
        // Do nothing right now
    }

}
