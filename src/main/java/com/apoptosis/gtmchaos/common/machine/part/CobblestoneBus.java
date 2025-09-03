package com.apoptosis.gtmchaos.common.machine.part;

import com.apoptosis.gtmchaos.GTMChaosMod;
import com.apoptosis.gtmchaos.config.GTMChaosConfig;
import com.apoptosis.gtmchaos.registrate.GTMChaosRegistrate;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class CobblestoneBus {
    public static MachineDefinition COBBLESTONE_BUS;

    static {
        if(GTMChaosConfig.INSTANCE.featureConfig.cobblestoneBus) {
            COBBLESTONE_BUS = GTMChaosRegistrate.REGISTRATE.machine("cobblestone_bus", holder -> new InfiniteItemBus(holder, GTValues.MAX, IO.IN, new ItemStack(Items.COBBLESTONE, 6400)))
                    .langValue("Infinite Cobblestone Bus")
                    .rotationState(RotationState.ALL)
                    .abilities(PartAbility.IMPORT_ITEMS)
                    .tier(GTValues.EV)
                    .tooltips(Component.translatable("gtceu.part_sharing.enabled"), Component.translatable("gtmchaos.machine.cobblestone_bus.tooltip"))
                    .overlayTieredHullModel(GTMChaosMod.id("block/machine/part/cobblestone_bus")).register();
        }
    }

    public static void init() {}
}
