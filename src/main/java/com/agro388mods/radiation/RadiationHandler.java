// Path: src/main/java/com/agro388mods/radiation/RadiationHandler.java
package com.agro388mods.radiation;

import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

@Mod.EventBusSubscriber
public class RadiationHandler {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        Player player = event.player;
        if (player.level.isClientSide) return;

        int totalRadiation = 0;
        for (int x = -2; x <= 2; x++) {
            for (int y = -2; y <= 2; y++) {
                for (int z = -2; z <= 2; z++) {
                    BlockState state = player.level.getBlockState(player.blockPosition().offset(x, y, z));
                    if (state.getBlock() instanceof RadiationBlock rb) {
                        totalRadiation += rb.getRadiationLevel();
                    }
                }
            }
        }

        if (totalRadiation > 0) {
            player.hurt(player.damageSources().magic(), totalRadiation * 0.1f);
        }
    }
}
