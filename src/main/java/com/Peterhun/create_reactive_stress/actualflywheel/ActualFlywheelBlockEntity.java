package com.Peterhun.create_reactive_stress.actualflywheel;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.createmod.catnip.animation.LerpedFloat;
import net.createmod.catnip.animation.LerpedFloat.Chaser;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class ActualFlywheelBlockEntity extends KineticBlockEntity {

	LerpedFloat visualSpeed = LerpedFloat.linear();
	float angle;

    public ActualFlywheelBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ACTUAL_FLYWHEEL_BE.get(), pos, state);
    }



    @Override
	protected AABB createRenderBoundingBox() {
		return super.createRenderBoundingBox().inflate(2);
	}

	@Override
	public void write(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
		super.write(compound, registries, clientPacket);
	}

	@Override
	protected void read(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
		super.read(compound, registries, clientPacket);
		if (clientPacket)
			visualSpeed.chase(getGeneratedSpeed(), 1 / 64f, Chaser.EXP);
	}

	@Override
	public void tick() {
		super.tick();

        assert level != null;
        if (!level.isClientSide)
			return;

		float targetSpeed = getSpeed();
		visualSpeed.updateChaseTarget(targetSpeed);
		visualSpeed.tickChaser();
		angle += visualSpeed.getValue() * 3 / 10f;
		angle %= 360;
	}
}
