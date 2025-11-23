package com.Peterhun.create_reactive_stress.block;

import com.Peterhun.create_reactive_stress.CreateReactiveStress;
import com.Peterhun.create_reactive_stress.actualflywheel.ActualFlywheelBlock;
import com.Peterhun.create_reactive_stress.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CreateReactiveStress.MODID);




    public static final DeferredBlock<ActualFlywheelBlock> ACTUAL_FLYWHEEL =
            BLOCKS.register("actual_flywheel",
                    () -> new ActualFlywheelBlock(BlockBehaviour.Properties.of()
                            .strength(5f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.METAL)));

    static {
        // FIX: register the BlockItem manually
        ModItems.ITEMS.register("actual_flywheel",
                () -> new BlockItem(ACTUAL_FLYWHEEL.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
