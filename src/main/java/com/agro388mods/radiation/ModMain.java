// Path: src/main/java/com/agro388mods/radiation/ModMain.java
package com.agro388mods.radiation;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;

@Mod("mekanismradiationexpansion")
public class ModMain {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "mekanismradiationexpansion");

    public static final RegistryObject<Block> LEAD_BLOCK = BLOCKS.register("lead_block", () -> new RadiationBlock(1));
    public static final RegistryObject<Block> URANIUM_BLOCK = BLOCKS.register("uranium_block", () -> new RadiationBlock(3));
    public static final RegistryObject<Block> TIERED_DEVICE = BLOCKS.register("tiered_device", TieredDevice::new);

    public static final DeferredRegister<BlockItem> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "mekanismradiationexpansion");

    public ModMain() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);

        BLOCKS.getEntries().forEach(block -> ITEMS.register(block.getId().getPath(), () ->
                new BlockItem(block.get(), new BlockItem.Properties().tab(CreativeModeTab.TAB_MISC))));
    }
                                                                           }
