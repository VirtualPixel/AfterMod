package net.id.after.world.biome;

import net.id.after.world.feature.placed_features.AfterPlacedFeatures;
import net.minecraft.world.biome.GenerationSettings.Builder;
import net.minecraft.world.gen.GenerationStep.Feature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class AfterBiomeFeatures extends DefaultBiomeFeatures {
    public AfterBiomeFeatures(){

    }

    public static void addDefaultOres(Builder builder){
        addDefaultOres(builder, false);
    }

    public static void addDefaultOres(Builder builder, boolean largeCopperOreBlob){
        builder.feature(Feature.UNDERGROUND_ORES, AfterPlacedFeatures.ORE_PHANTONIUM);
    }
}
