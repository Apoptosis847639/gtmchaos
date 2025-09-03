package com.apoptosis.gtmchaos.config;

import com.apoptosis.gtmchaos.GTMChaosMod;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.ConfigHolder;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = GTMChaosMod.MOD_ID)
public class GTMChaosConfig {
    public static GTMChaosConfig INSTANCE;

    public static ConfigHolder<GTMChaosConfig> CONFIG_HOLDER;

    public static void init() {
        CONFIG_HOLDER = Configuration.registerConfig(GTMChaosConfig.class, ConfigFormats.yaml());
        INSTANCE = CONFIG_HOLDER.getConfigInstance();
    }

    @Configurable
    public FeatureConfigs featureConfig = new FeatureConfigs();

    public static class FeatureConfigs {
        @Configurable
        @Configurable.Comment({" Enables Water Reservoir Hatch "})
        public boolean cobblestoneBus = true;
        @Configurable
        @Configurable.Comment({" Enables Cleaning Cover "})
        public boolean cleaningCover = true;
        @Configurable
        @Configurable.Comment({" Enables Sterile Cleaning Cover(Requires GTMUtils) it won't have a recipe "})
        public boolean sterileCleaningCover = true;
    }
}
