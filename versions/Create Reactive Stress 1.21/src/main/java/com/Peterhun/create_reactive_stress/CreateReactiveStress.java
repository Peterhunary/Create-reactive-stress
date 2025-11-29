package com.Peterhun.create_reactive_stress;


//import com.Peterhun.create_reactive_stress.actualflywheel.ModBlockEntities;
//import com.Peterhun.create_reactive_stress.block.ModBlocks;
//import com.Peterhun.create_reactive_stress.item.ModItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;


@Mod("create_reactive_stress")
public final class CreateReactiveStress {

    public static final String MODID = "create_reactive_stress";
    public static final CreateRegistrate REGISTRATE=CreateRegistrate.create(MODID);

    public CreateReactiveStress(IEventBus ModEventBus, ModContainer container) {
        ModEventBus.addListener(this::commonSetup);
        REGISTRATE.registerEventListeners(ModEventBus);
//        ModBlocks.register(ModEventBus);
//        ModItems.register(ModEventBus);
//        ModBlockEntities.register(ModEventBus);
//        ModEventBus.addListener(this::addCreative);
        container.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

//    private void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey()== CreativeModeTabs.REDSTONE_BLOCKS) {
//            event.accept(ModBlocks.ACTUAL_FLYWHEEL);
//        }
//
//    }

}
