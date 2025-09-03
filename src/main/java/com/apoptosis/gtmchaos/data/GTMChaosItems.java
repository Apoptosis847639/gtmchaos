package com.apoptosis.gtmchaos.data;

import com.apoptosis.gtmchaos.common.covers.GTMChaosCovers;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static com.apoptosis.gtmchaos.registrate.GTMChaosRegistrate.REGISTRATE;
import static com.gregtechceu.gtceu.common.data.GTItems.attach;

public class GTMChaosItems {
    public static ItemEntry<ComponentItem> COVER_CLEANING = REGISTRATE
            .item("cleaning_cover", ComponentItem::create)
            .lang("Cleaning Cover")
            .onRegister(attach(new CoverPlaceBehavior(GTMChaosCovers.CLEANING_COVER)))
            .register();
    public static ItemEntry<Item> ANCIENT_GOLD_COIN = null;
    public static ItemEntry<Item> CHOCOLATE_COIN = null;
    public static ItemEntry<Item> COPPER_CREDIT = null;
    public static ItemEntry<Item> CUPRONICKEL_CREDIT = null;
    public static ItemEntry<Item> DOGE_COIN = null;
    public static ItemEntry<Item> GOLD_CREDIT = null;
    public static ItemEntry<Item> NAQUADAH_CREDIT = null;
    public static ItemEntry<Item> NEUTRONIUM_CREDIT = null;
    public static ItemEntry<Item> OSMIUM_CREDIT = null;
    public static ItemEntry<Item> PLATINUM_CREDIT = null;
    public static ItemEntry<Item> SILVER_CREDIT = null;
    static {
        ANCIENT_GOLD_COIN = registerBasicItem("ancient_gold_coin");
        CHOCOLATE_COIN = registerBasicItem("chocolate_coin");
        COPPER_CREDIT = registerBasicItem("copper_credit");
        CUPRONICKEL_CREDIT = registerBasicItem("cupronickel_credit");
        DOGE_COIN = registerBasicItem("doge_coin");
        GOLD_CREDIT = registerBasicItem("gold_credit");
        NAQUADAH_CREDIT = registerBasicItem("naquadah_credit");
        NEUTRONIUM_CREDIT = registerBasicItem("neutronium_credit");
        OSMIUM_CREDIT = registerBasicItem("osmium_credit");
        PLATINUM_CREDIT = registerBasicItem("platinum_credit");
        SILVER_CREDIT = registerBasicItem("silver_credit");
    }

    public static ItemEntry<Item> registerBasicItem(String id) {
        return REGISTRATE
                .item(id, Item::new)
                .initialProperties(Item.Properties::new)
                .register();
    }

    public static void init() {}
}
