package net.kuko.fisch.item;

import net.kuko.fisch.Fisch;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Fisch.MOD_ID);



    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
