package com.Peterhun.create_reactive_stress.actualflywheel;

import com.Peterhun.create_reactive_stress.CreateReactiveStress;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.flywheel.FlywheelBlockEntity;
import com.simibubi.create.content.kinetics.flywheel.FlywheelRenderer;
import com.simibubi.create.content.kinetics.flywheel.FlywheelVisual;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.Peterhun.create_reactive_stress.CreateReactiveStress.REGISTRATE;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(net.minecraft.core.registries.Registries.BLOCK_ENTITY_TYPE,
                    CreateReactiveStress.MODID);

    public static final BlockEntityEntry<FlywheelBlockEntity> FLYWHEEL = REGISTRATE
            .blockEntity("flywheel", FlywheelBlockEntity::new)
            .visual(() -> FlywheelVisual::new, false)
            .validBlocks(AllBlocks.FLYWHEEL)
            .renderer(() -> FlywheelRenderer::new)
            .register();

    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
