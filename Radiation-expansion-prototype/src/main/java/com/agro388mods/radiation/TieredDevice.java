package com.agro388mods.radiation;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.material.Material;

public class TieredDevice extends Block {

    public enum Tier { BASIC, ADVANCED, ELITE }

    private Tier tier;

    public TieredDevice() {
        super(BlockBehaviour.Properties.of(Material.METAL).strength(4f, 5f));
        this.tier = Tier.BASIC;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public Tier getTier() {
        return tier;
    }

    public int getProcessingSpeed() {
        return switch(tier) {
            case BASIC -> 1;
            case ADVANCED -> 3;
            case ELITE -> 5;
        };
    }

    public int getCapacity() {
        return switch(tier) {
            case BASIC -> 1000;
            case ADVANCED -> 5000;
            case ELITE -> 10000;
        };
    }
}
