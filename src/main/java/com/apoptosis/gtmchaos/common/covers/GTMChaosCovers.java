package com.apoptosis.gtmchaos.common.covers;

import com.apoptosis.gtmchaos.GTMChaosMod;
import com.apoptosis.gtmchaos.config.GTMChaosConfig;
import com.apoptosis.gtmchaos.registrate.GTMChaosRegistrate;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.client.renderer.cover.ICoverRenderer;
import com.gregtechceu.gtceu.client.renderer.cover.SimpleCoverRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

import static com.apoptosis.gtmchaos.registrate.GTMChaosRegistrate.COVERS;

public class GTMChaosCovers {
    public static CoverDefinition CLEANING_COVER;

    private static CoverDefinition register(String id, CoverDefinition.CoverBehaviourProvider behaviorCreator) {
        return register(id, behaviorCreator, () -> () -> new SimpleCoverRenderer(GTCEu.id("block/cover/" + id)));
    }
    private static CoverDefinition register(String id, CoverDefinition.CoverBehaviourProvider behaviorCreator,
                                            Supplier<Supplier<ICoverRenderer>> coverRenderer) {
        return register(GTMChaosMod.id(id), behaviorCreator, coverRenderer);
    }

    public static CoverDefinition register(ResourceLocation id, CoverDefinition.CoverBehaviourProvider behaviorCreator,
                                           Supplier<Supplier<ICoverRenderer>> coverRenderer) {
        var definition = new CoverDefinition(id, behaviorCreator, coverRenderer);
        GTRegistries.COVERS.register(definition.getId(), definition);
        GTMChaosMod.LOGGER.info(id + " has been registered as a cover");
        return definition;
    }

    public static void init() {
        if (GTMChaosConfig.INSTANCE.featureConfig.cleaningCover) {
            GTMChaosMod.LOGGER.info("Cleaning Cover Registered");
            CLEANING_COVER = register("cleaning_cover", (definition, coverable, side) -> new CleaningCovers(definition, coverable, side, CleanroomType.CLEANROOM));
        }
    }
}
