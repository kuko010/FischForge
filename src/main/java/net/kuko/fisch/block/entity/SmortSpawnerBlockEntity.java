package net.kuko.fisch.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SmortSpawnerBlockEntity extends BlockEntity {
    public SmortSpawnerBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.SMORT_SPAWNER_BE.get(), pos, blockState);
    }
}
