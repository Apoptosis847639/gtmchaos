package com.apoptosis.gtmchaos.registrate;

import com.apoptosis.gtmchaos.GTMChaosMod;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.cover.CoverDefinition;
import com.gregtechceu.gtceu.api.registry.GTRegistry;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.tterrag.registrate.Registrate;

public class GTMChaosRegistrate {
    public static GTRegistrate REGISTRATE = GTRegistrate.create(GTMChaosMod.MOD_ID);
    public static final GTRegistry.RL<CoverDefinition> COVERS = new GTRegistry.RL<>(GTMChaosMod.id("cover"));

    public static void init() {
        REGISTRATE.registerRegistrate();
    }
}
