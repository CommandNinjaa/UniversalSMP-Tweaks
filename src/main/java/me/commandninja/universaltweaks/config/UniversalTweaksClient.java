package me.commandninja.universaltweaks.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class UniversalTweaksClient {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Universal - Tweaks Config");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
