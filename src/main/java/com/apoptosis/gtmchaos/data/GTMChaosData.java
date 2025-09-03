package com.apoptosis.gtmchaos.data;

import com.apoptosis.gtmchaos.data.lang.LangProvider;
import com.apoptosis.gtmchaos.registrate.GTMChaosRegistrate;
import com.tterrag.registrate.providers.ProviderType;

public class GTMChaosData {
    public static void init() {
        GTMChaosRegistrate.REGISTRATE.addDataGenerator(ProviderType.LANG, LangProvider::init);
    }
}
