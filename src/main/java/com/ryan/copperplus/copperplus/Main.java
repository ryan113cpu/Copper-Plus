package com.ryan.copperplus.copperplus;

import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {

    @Override
    public void onInitialize() {
        ModItems.initialize();
    }
}