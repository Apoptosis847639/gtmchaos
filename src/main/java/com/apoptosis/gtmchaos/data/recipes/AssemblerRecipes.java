package com.apoptosis.gtmchaos.data.recipes;

import com.apoptosis.gtmchaos.GTMChaosMod;
import com.apoptosis.gtmchaos.common.machine.GTMChaosMachine;
import com.apoptosis.gtmchaos.common.machine.part.CobblestoneBus;
import com.apoptosis.gtmchaos.config.GTMChaosConfig;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.data.recipe.GTCraftingComponents;
import com.gregtechceu.gtceu.data.recipe.misc.AssemblerRecipeLoader;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class AssemblerRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        if(GTMChaosConfig.INSTANCE.featureConfig.cobblestoneBus) {
            GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(GTMChaosMod.id("cobblestone_bus_recipe"))
                    .inputItems(GTMachines.ROCK_CRUSHER[GTValues.EV])
                    .inputItems(GTMachines.ITEM_IMPORT_BUS[GTValues.EV])
                    .inputItems(GTCraftingComponents.CONVEYOR.get(GTValues.EV))
                    .inputItems(new ItemStack(Items.MAGMA_BLOCK))
                    .inputItems(new ItemStack(Items.PACKED_ICE))
                    .inputItems(GTCraftingComponents.CIRCUIT.get(GTValues.MV))
                    .outputItems(CobblestoneBus.COBBLESTONE_BUS.asStack(1))
                    .EUt(GTValues.VHA[GTValues.EV])
                    .save(provider);
        }
    }
}
