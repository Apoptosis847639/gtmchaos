package com.apoptosis.gtmchaos.common.machine.part;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.gregtechceu.gtceu.common.machine.multiblock.part.CleaningMaintenanceHatchPartMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.part.FluidHatchPartMachine;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;

import java.util.Objects;

public class InfiniteFluidHatch extends FluidHatchPartMachine {
    private TickableSubscription subscription;

    public InfiniteFluidHatch(IMachineBlockEntity holder, int tier, IO io, int initialCapacity, int slots, Object... args) {
        super(holder, tier, io, initialCapacity, slots, args);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        subscription = holder.getMetaMachine().subscribeServerTick(subscription, this::update);
    }

    private void update() {
        this.tank.setFluidInTank(0, new FluidStack(Fluids.WATER, Integer.MAX_VALUE));
    }

    @Override
    protected NotifiableFluidTank createTank(int initialCapacity, int slots, Object... args) {


        return super.createTank(initialCapacity, slots, args);
    }


}
