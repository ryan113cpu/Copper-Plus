package com.ryan.copperplus.copperplus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, context, type, tooltip) -> {
            if (stack.is(ModItems.COPPER_MAGNET)) {
                boolean on = stack.getOrDefault(ModComponents.MAGNET_ON, false);

                if (on) {
                    tooltip.add(Component.literal("Magnet: ON").withStyle(ChatFormatting.GREEN));
                } else {
                    tooltip.add(Component.literal("Magnet: OFF").withStyle(ChatFormatting.RED));
                }
            }
        });
    }
}