package net.kuko.fisch;

import com.mojang.logging.LogUtils;
//import net.kapitencraft.kap_lib.KapLibMod;
import net.kuko.fisch.block.ModBlocks;
import net.kuko.fisch.block.entity.ModBlockEntities;
import net.kuko.fisch.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Fisch.MOD_ID)
public class Fisch {
    public static final String MOD_ID = "fisch";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation rl(String s) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, s);
    }

    public Fisch(FMLJavaModLoadingContext context) {
        IEventBus eventBus = context.getModEventBus();
        eventBus.addListener(this::commonSetup);


        // Regs!
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModBlockEntities.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::addCreative);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.SMORT_SPAWNER.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
        }
    }
}
