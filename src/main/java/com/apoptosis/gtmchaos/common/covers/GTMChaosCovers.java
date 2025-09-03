package com.apoptosis.gtmchaos.common.covers;

import com.apoptosis.gtmchaos.GTMChaosMod;
import com.apoptosis.gtmchaos.config.GTMChaosConfig;
import com.apoptosis.gtmchaos.registrate.GTMChaosRegistrate;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.IComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.client.renderer.cover.ICoverRenderer;
import com.gregtechceu.gtceu.client.renderer.cover.SimpleCoverRenderer;
import com.gregtechceu.gtceu.common.cover.InfiniteWaterCover;
import com.gregtechceu.gtceu.common.cover.voiding.AdvancedItemVoidingCover;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.apoptosis.gtmchaos.registrate.GTMChaosRegistrate.COVERS;
import static com.apoptosis.gtmchaos.registrate.GTMChaosRegistrate.REGISTRATE;

public class GTMChaosCovers {
    public static final List<CoverDefinition> ALL_COVERS = new ArrayList<>(1);

    public static CoverDefinition CLEANING_COVER;
    public static CoverDefinition STERILE_CLEANING_COVER;

    public static ItemEntry<ComponentItem> COVER_CLEANING_ITEM;
    public static ItemEntry<ComponentItem> COVER_STERILE_CLEANING_ITEM;

    public static void init() {
        if (GTMChaosConfig.INSTANCE.featureConfig.cleaningCover) {
            GTMChaosMod.LOGGER.info("Cleaning Cover Registered");
            CLEANING_COVER = register("cleaning_cover", (definition, coverable, side) -> new CleaningCovers(definition, coverable, side, CleanroomType.CLEANROOM));

            COVER_CLEANING_ITEM = REGISTRATE
                    .item("cleaning_cover", ComponentItem::create)
                    .lang("Cleaning Cover")
                    .onRegister(attach(new CoverPlaceBehavior(GTMChaosCovers.CLEANING_COVER)))
                    .register();

        }

        if (GTMChaosConfig.INSTANCE.featureConfig.sterileCleaningCover && GTCEu.isModLoaded("gtmutils")) {
            STERILE_CLEANING_COVER = register("sterile_cleaning_cover", (definition, coverable, side) -> new CleaningCovers(definition, coverable, side, CleanroomType.STERILE_CLEANROOM));

            COVER_STERILE_CLEANING_ITEM = REGISTRATE
                    .item("sterile_cleaning_cover", ComponentItem::create)
                    .lang("Sterilizing Cleaning Cover")
                    .onRegister(attach(new CoverPlaceBehavior(GTMChaosCovers.STERILE_CLEANING_COVER)))
                    .register();
        }
    }
    //Stolen from GTCovers
    private static CoverDefinition register(String id, CoverDefinition.CoverBehaviourProvider behaviorCreator) {
        return register(id, behaviorCreator, () -> () -> new SimpleCoverRenderer(GTMChaosMod.id("block/cover/" + id)));
    }

    private static CoverDefinition register(String id, CoverDefinition.CoverBehaviourProvider behaviorCreator,
                                            Supplier<Supplier<ICoverRenderer>> coverRenderer) {
        return register(GTMChaosMod.id(id), behaviorCreator, coverRenderer);
    }

    public static CoverDefinition register(ResourceLocation id, CoverDefinition.CoverBehaviourProvider behaviorCreator,
                                           Supplier<Supplier<ICoverRenderer>> coverRenderer) {
        var definition = new CoverDefinition(id, behaviorCreator, coverRenderer);
        System.out.println(definition);
        GTRegistries.COVERS.register(definition.getId(), definition);
        return definition;
    }

    //Stolen from GTItems.java :3
    public static <T extends IComponentItem > NonNullConsumer<T> attach(IItemComponent... components) {
        return item -> item.attachComponents(components);
    }
}
