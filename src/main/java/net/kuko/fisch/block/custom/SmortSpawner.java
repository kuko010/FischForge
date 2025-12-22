package net.kuko.fisch.block.custom;

import net.kuko.fisch.block.entity.SmortSpawnerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.checkerframework.checker.nullness.qual.Nullable;

public class SmortSpawner extends BaseEntityBlock {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 12, 16);


    public SmortSpawner(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
    // Logic
    // ...
    // End Logic


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SmortSpawnerBlockEntity(pos, state);
    }
}
