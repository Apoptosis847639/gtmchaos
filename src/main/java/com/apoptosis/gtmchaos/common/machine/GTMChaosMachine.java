package com.apoptosis.gtmchaos.common.machine;

import com.apoptosis.gtmchaos.common.machine.part.CobblestoneBus;
import com.apoptosis.gtmchaos.config.GTMChaosConfig;

public class GTMChaosMachine {
    public static void init() {
        if (GTMChaosConfig.INSTANCE.featureConfig.cobblestoneBus) {
            CobblestoneBus.init();
        }
    }
}
