package net.kuko.fisch.client;


import net.kuko.fisch.Fisch;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Fisch.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FischClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {



    }
}
