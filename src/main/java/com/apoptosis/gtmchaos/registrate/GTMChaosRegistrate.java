package com.apoptosis.gtmchaos.registrate;

import com.apoptosis.gtmchaos.GTMChaosMod;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

public class GTMChaosRegistrate {
    public static GTRegistrate REGISTRATE = GTRegistrate.create(GTMChaosMod.MOD_ID);

    public static void init() {
        REGISTRATE.registerRegistrate();
    }
}
