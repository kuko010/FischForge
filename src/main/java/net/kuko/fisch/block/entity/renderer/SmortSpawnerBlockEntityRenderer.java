package net.kuko.fisch.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.kuko.fisch.block.entity.SmortSpawnerBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.DisplayRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class SmortSpawnerBlockEntityRenderer implements BlockEntityRenderer<SmortSpawnerBlockEntity> {
    public SmortSpawnerBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }


    @Override
    public void render(SmortSpawnerBlockEntity blockEntity, float partialTick,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = new ItemStack(Items.DIAMOND, 1);

        poseStack.pushPose();
        poseStack.translate(0,0,0);
        poseStack.scale(1,1,1);
        EntityRenderDispatcher dispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        dispatcher.render(new Zombie(blockEntity.getLevel()),0.5,0.5,0.5, 0,
                partialTick, poseStack, buffer, getLightLevel(blockEntity.getLevel(), blockEntity.getBlockPos()));

        poseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
