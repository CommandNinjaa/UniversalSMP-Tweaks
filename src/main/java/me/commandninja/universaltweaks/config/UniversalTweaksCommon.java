package me.commandninja.universaltweaks.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class UniversalTweaksCommon {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> IMMUNE_ITEMS;

    static {
        BUILDER.push("Universal - Tweaks Config");

        IMMUNE_ITEMS = BUILDER.comment("List of the items that are imune to cacti")
                .defineList("Immune Items", List.of("lifesteal:revive_crystal", "lifesteal:heart_crystal"), obj -> obj instanceof String);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
