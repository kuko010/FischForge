package net.kuko.fisch.item;

import net.kuko.fisch.Fisch;
import net.kuko.fisch.item.custom.LightItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Fisch.MOD_ID);

    Item a = Items.DIAMOND_SWORD;

    public static final RegistryObject<Item> LIGHT_ITEM = ITEMS.register("light_item",
            () -> new LightItem(new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
