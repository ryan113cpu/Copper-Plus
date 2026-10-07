package com.ryan.copperplus.copperplus;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItems {

    public static Item register(
            ResourceKey<Item> itemKey,
            Function<Item.Properties, Item> itemFactory,
            Item.Properties settings
    ) {
        Item item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }

    public static final Item COPPER_WIRE = register(
            ModItemIds.COPPER_WIRE,
            Item::new,
            new Item.Properties()
    );

    public static final Item COPPER_MAGNET = register(
            ModItemIds.COPPER_MAGNET,
            CopperMagnetItem::new,
            new Item.Properties()
    );

    public static void initialize() {
    }
}