package com.jakeberryman.goofsterpack;


import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Goofsterpack.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue GENERATE_CERTUS_ORE = BUILDER
            .comment("Should the mod add Certus Quartz ore from old AE2 versions?")
            .define("generateCertusOre", false);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean generateCertusOre;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        generateCertusOre = GENERATE_CERTUS_ORE.get();
    }
}