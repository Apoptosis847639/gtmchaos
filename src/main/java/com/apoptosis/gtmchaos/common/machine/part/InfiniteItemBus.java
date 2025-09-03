package com.apoptosis.gtmchaos.common.machine.part;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.common.machine.multiblock.part.ItemBusPartMachine;
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.gui.widget.WidgetGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class InfiniteItemBus extends ItemBusPartMachine {
    private final ItemStack stack;
    private TickableSubscription subscription;


    public InfiniteItemBus(IMachineBlockEntity holder, int tier, IO io, ItemStack stack, Object... args) {

        super(holder, tier, io ,args);
        this.stack = stack;

    }

    @Override
    public void onMachineRemoved() {
        for(int i = 0; i < stack.getCount() / 64; i++)
            this.getInventory().setStackInSlot(i, ItemStack.EMPTY);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        subscription = holder.getMetaMachine().subscribeServerTick(subscription, this::update);

    }

    private void update() {
        for(int i = 0; i < stack.getCount() / 64; i++)
            this.getInventory().insertItem(i, new ItemStack(stack.getItem(), 64), false);
    }

    @Override
    public Widget createUIWidget() {
        var group = new WidgetGroup(0, 0, 18, 18);
        return group;
    }
}
