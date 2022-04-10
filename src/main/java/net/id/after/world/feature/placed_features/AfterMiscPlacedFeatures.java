package net.id.after.world.feature.placed_features;

import net.id.after.world.feature.configured_features.AfterMiscConfiguredFeatures;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class AfterMiscPlacedFeatures extends AfterPlacedFeatures{
    public static final RegistryEntry<PlacedFeature> ORE_PHANTONIUM = register("phantonium_ore", AfterMiscConfiguredFeatures.ORE_PHANTONIUM, CountPlacementModifier.of(20), SquarePlacementModifier.of(), HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(0), YOffset.aboveBottom(0)), BiomePlacementModifier.of());

    public static void init(){}
}
