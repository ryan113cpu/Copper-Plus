package com.ryan.copperplus.copperplus;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {
    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath("copper-plus", name)
        );
    }

    public static final ResourceKey<Item> COPPER_WIRE = create("copper_wire");
    public static final ResourceKey<Item> COPPER_MAGNET = create("copper_magnet");
}