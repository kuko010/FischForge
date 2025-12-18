package net.kuko.fisch.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.JukeboxBlockEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import net.minecraft.world.level.gameevent.GameEvent;

@Mixin(GameEvent.class)
public class ExampleMixin {
//
//    @Final
//    @Shadow
//    @Mutable
////    public static GameEvent JUKEBOX_PLAY = GameEvent.register("jukebox_play", 64);;
}
