package com.clovermod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(CloverMod.MOD_ID)
public class CloverMod {
    public static final String MOD_ID = "clovermod";

    public CloverMod(IEventBus modBus) {
        ModItems.ITEMS.register(modBus);
        ModItems.TABS.register(modBus);
    }
}
