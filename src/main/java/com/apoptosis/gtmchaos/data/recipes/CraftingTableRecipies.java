package com.apoptosis.gtmchaos.data.recipes;

import com.apoptosis.gtmchaos.GTMChaosMod;
import com.apoptosis.gtmchaos.common.covers.GTMChaosCovers;
import com.apoptosis.gtmchaos.config.GTMChaosConfig;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterialItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.GTCraftingComponents;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class CraftingTableRecipies {
    public static void init(Consumer<FinishedRecipe> provider) {
        if(GTMChaosConfig.INSTANCE.featureConfig.cleaningCover) {
            VanillaRecipeHelper.addShapedRecipe(provider, true, GTMChaosMod.id("cleaning_cover_recipe"),
                    GTMChaosCovers.COVER_CLEANING_ITEM.asStack(), "CRC", "MOM", "CRC",
                    'C', GTCraftingComponents.CIRCUIT.get(GTValues.ZPM),
                    'R', GTCraftingComponents.ROBOT_ARM.get(GTValues.ZPM),
                    'M', GTCraftingComponents.MOTOR.get(GTValues.HV),
                    'O', new MaterialEntry(TagPrefix.gear, GTMaterials.Osmiridium));
        }
    }
}
