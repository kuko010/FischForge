package net.kuko.fisch.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class SmortSpawnerBlockEntity extends BlockEntity {
    public final ItemStackHandler inventory = new ItemStackHandler(27);

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;

    public SmortSpawnerBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.SMORT_SPAWNER_BE.get(), pos, blockState);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                if (index == 0) { return SmortSpawnerBlockEntity.this.progress; }
                if (index == 1) { return SmortSpawnerBlockEntity.this.maxProgress; }
                return 0;
            }

            @Override
            public void set(int index, int value) {
                if (index == 0) { SmortSpawnerBlockEntity.this.progress = value; }
                if (index == 1) { SmortSpawnerBlockEntity.this.maxProgress = value; }
            }

            @Override
            public int getCount() {
                return 64;
            }
        };
    }


    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    public void clearSlot(int slot) {
        inventory.setStackInSlot(slot, null);
    }


    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> inventory);
    }



    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", inventory.serializeNBT());
        pTag.putInt("smort_spawner.progress", progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        inventory.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("smort_spawner.progress");
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(inventory.getSlots());
        for(int i = 0; i < inventory.getSlots(); i++) {
            inv.setItem(i, inventory.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

}
