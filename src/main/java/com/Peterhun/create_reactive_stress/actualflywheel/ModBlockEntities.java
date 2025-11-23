package com.Peterhun.create_reactive_stress.actualflywheel;

import com.Peterhun.create_reactive_stress.CreateReactiveStress;
import com.Peterhun.create_reactive_stress.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(net.minecraft.core.registries.Registries.BLOCK_ENTITY_TYPE,
                    CreateReactiveStress.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ActualFlywheelBlockEntity>>
            ACTUAL_FLYWHEEL_BE = BLOCK_ENTITIES.register("actual_flywheel",
            () -> BlockEntityType.Builder
                    .of(ActualFlywheelBlockEntity::new,
                            ModBlocks.ACTUAL_FLYWHEEL.get())
                    .build(null));

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
