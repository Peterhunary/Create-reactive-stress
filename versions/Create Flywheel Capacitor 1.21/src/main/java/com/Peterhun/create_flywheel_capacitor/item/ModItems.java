package com.Peterhun.create_reactive_stress.item;

import com.Peterhun.create_reactive_stress.CreateReactiveStress;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateReactiveStress.MODID);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
