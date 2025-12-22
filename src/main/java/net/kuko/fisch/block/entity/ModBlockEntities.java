package net.kuko.fisch.block.entity;

import net.kuko.fisch.Fisch;
import net.kuko.fisch.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.IModBusEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Fisch.MOD_ID);

    public static final RegistryObject<BlockEntityType<SmortSpawnerBlockEntity>> SMORT_SPAWNER_BE =
            BLOCK_ENTITY.register("smort_spawner_be",
                    () -> BlockEntityType.Builder.of(SmortSpawnerBlockEntity::new,
                            ModBlocks.SMORT_SPAWNER.get()).build(null));

    public static void register(IEventBus bus) {
        BLOCK_ENTITY.register(bus);
    }
}
