package com.ryan.copperplus.copperplus;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CopperMagnetItem extends Item {

    public CopperMagnetItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        boolean current = stack.getOrDefault(ModComponents.MAGNET_ON, false);
        stack.set(ModComponents.MAGNET_ON, !current);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void inventoryTick(
            ItemStack stack,
            ServerLevel level,
            Entity owner,
            EquipmentSlot slot
    ) {
        if (!(owner instanceof Player player)) {
            return;
        }

        if (slot != EquipmentSlot.MAINHAND && slot != EquipmentSlot.OFFHAND) {
            return;
        }

        if (!stack.getOrDefault(ModComponents.MAGNET_ON, false)) {
            return;
        }

        AABB area = player.getBoundingBox().inflate(8);

        for (ItemEntity item : level.getEntitiesOfClass(ItemEntity.class, area)) {
            Vec3 direction = new Vec3(
                    player.getX() - item.getX(),
                    player.getY() + 0.5 - item.getY(),
                    player.getZ() - item.getZ()
            ).normalize();

            item.setDeltaMovement(
                    item.getDeltaMovement().add(direction.scale(0.08))
            );
        }
    }
}