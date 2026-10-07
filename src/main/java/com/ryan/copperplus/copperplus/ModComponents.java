package com.ryan.copperplus.copperplus;

import com.mojang.serialization.Codec;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.Identifier;

public class ModComponents {

    public static final DataComponentType<Boolean> MAGNET_ON = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath("copper-plus", "magnet_on"),
            DataComponentType.<Boolean>builder()
                    .persistent(Codec.BOOL)
                    .build()
    );

    public static void initialize() {
    }
}