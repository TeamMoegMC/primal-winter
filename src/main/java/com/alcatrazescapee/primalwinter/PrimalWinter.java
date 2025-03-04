/*
 * Part of the Primal Winter mod by AlcatrazEscapee.
 * Work under copyright. See the project LICENSE.md for details.
 */

package com.alcatrazescapee.primalwinter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.alcatrazescapee.primalwinter.client.ClientEventHandler;
import com.alcatrazescapee.primalwinter.client.ModParticleTypes;
import com.alcatrazescapee.primalwinter.client.ModSoundEvents;
import com.alcatrazescapee.primalwinter.common.ModBlocks;
import com.alcatrazescapee.primalwinter.common.ModItems;
import com.alcatrazescapee.primalwinter.world.ModFeatures;


@Mod(PrimalWinter.MOD_ID)
public final class PrimalWinter
{
    public static final String MOD_ID = "primalwinter";

    private static final Logger LOGGER = LogManager.getLogger();

    public PrimalWinter()
    {
        LOGGER.debug("Constructing");

        // Setup config
        Config.init();

        // Register event handlers
        EventHandler.init();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientEventHandler::init);

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);
        ModSoundEvents.SOUND_EVENTS.register(modEventBus);
        ModParticleTypes.PARTICLE_TYPES.register(modEventBus);
    }
}