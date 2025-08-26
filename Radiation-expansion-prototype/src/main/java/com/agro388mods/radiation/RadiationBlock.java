package com.agro388mods.radiation;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.material.Material;

public class RadiationBlock extends Block {

    private final int radiationLevel;

    public RadiationBlock(int radiationLevel) {
        super(BlockBehaviour.Properties.of(Material.METAL).strength(5f, 6f));
        this.radiationLevel = radiationLevel;
    }

    public int getRadiationLevel() {
        return radiationLevel;
    }
}
