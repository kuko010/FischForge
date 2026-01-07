package net.kuko.fisch.event;


import net.kuko.fisch.Fisch;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Fisch.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusClientEvents {


    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
//        event.registerBlockEntityRenderer(ModBlockEntities.SMORT_SPAWNER_BE.get(), SmortSpawnerBlockEntityRenderer::new);
    }
}
