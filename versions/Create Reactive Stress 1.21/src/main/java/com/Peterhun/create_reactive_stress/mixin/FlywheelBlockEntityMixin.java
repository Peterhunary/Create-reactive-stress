//package com.Peterhun.create_reactive_stress.mixin;
//
//import com.simibubi.create.content.kinetics.flywheel.FlywheelBlockEntity;
//import net.createmod.catnip.animation.LerpedFloat;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraft.world.level.block.state.BlockState;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.Unique;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(FlywheelBlockEntity.class)
//public abstract class FlywheelBlockEntityMixin extends KineticBlockEntity {
//    @Shadow
//    LerpedFloat visualSpeed;
//    @Unique
//    KineticBlockEntity createReactiveStress$self = this;
//    @Unique
//    KineticBlockEntity createReactiveStress$be = this;
//
//    public FlywheelBlockEntityMixin(BlockEntityType<?> type, BlockPos pos, BlockState state) {
//        super(type, pos, state);
//    }
//
//    @Unique
//    boolean createReactiveStress$isCharged = false;
//    @Unique
//    float createReactiveStress$speed = createReactiveStress$self.getSpeed();
//    @Unique
//    float createReactiveStress$maxCapacity = (createReactiveStress$speed *16);
//    @Unique
//    float createReactiveStress$maxStress = (createReactiveStress$speed *32);
//    @Unique
//    float createReactiveStress$thresholdCapacity = (capacity - createReactiveStress$maxCapacity);
//    @Unique
//    int createReactiveStress$countDownStep = (int)(createReactiveStress$thresholdCapacity/createReactiveStress$maxCapacity);
//    @Unique
//    private int createReactiveStress$CountDownTimer = 1200;
//
//    @Inject(method = "tick",at = @At("HEAD"))
//    public void tick(CallbackInfo ci){
//
//        if (createReactiveStress$self.isOverStressed()){ createReactiveStress$isCharged = false; return;}
//        if (createReactiveStress$thresholdCapacity > createReactiveStress$maxCapacity){
//            createReactiveStress$CountDownTimer -= createReactiveStress$countDownStep;
//            if (createReactiveStress$CountDownTimer <= 0){
//                if (network!= null){
//                    createReactiveStress$self.getOrCreateNetwork().updateCapacityFor(createReactiveStress$self,0);}
//                    createReactiveStress$self.setChanged();
//                createReactiveStress$isCharged = false;
//            }
//        }
//
//        if (createReactiveStress$be instanceof FlywheelBlockEntity && !createReactiveStress$isCharged){
//            if (network!= null) {
//
//                createReactiveStress$self.getOrCreateNetwork().updateStressFor(createReactiveStress$self, createReactiveStress$maxStress);
//                createReactiveStress$self.setChanged();
//            }
//        }
//
//        if (createReactiveStress$be instanceof FlywheelBlockEntity &&(createReactiveStress$maxCapacity ==0)&&(createReactiveStress$speed ==visualSpeed.getValue())){
//            createReactiveStress$isCharged = true;
//            if (network!= null) {
//                createReactiveStress$self.getOrCreateNetwork().updateCapacityFor(createReactiveStress$self, createReactiveStress$maxCapacity);
//                createReactiveStress$self.setChanged();
//            }
//        }
//    }
//}
