package net.id.after.world.biome;


import net.id.after.world.gen.AfterChunkGenerator;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.List;
import java.util.Map;

import static net.id.after.After.MOD_ID;
import static net.id.after.world.feature.placed_features.AfterMiscPlacedFeatures.ORE_PHANTONIUM;

public class AfterBiomes {
    public static final RegistryKey<Biome> AFTER_BIOME_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "after_biome"));

    private static GenerationSettings createGenerationSettings(Map<GenerationStep.Feature, List<RegistryEntry<PlacedFeature>>> features) {
        var builder = new GenerationSettings.Builder();

        for (var step : GenerationStep.Feature.values()){
            for (var feature : features.getOrDefault(step, List.of())){
                builder.feature(step, feature);
            }
        }
        return builder.build();
    }

    private static Map<GenerationStep.Feature, List<RegistryEntry<PlacedFeature>>> getStandardAfterFeatures() {
        return Map.of(
                GenerationStep.Feature.UNDERGROUND_ORES, List.of(
                        ORE_PHANTONIUM
                )
        );
    }

    private static Biome AFTER(){
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        //DefaultBiomeFeatures.addFarmAnimals(spawnSettings);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addTallBirchTrees(generationSettings);
        DefaultBiomeFeatures.addBirchTrees(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        //DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
        AfterBiomeFeatures.addDefaultOres(generationSettings);


        return new Biome.Builder()
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.NONE)
                .precipitation(Biome.Precipitation.NONE)
                .temperature(0.8F)
                .downfall(0.4F)
                .category(Biome.Category.NONE)
                .effects((new BiomeEffects.Builder())
                        .particleConfig(new BiomeParticleConfig(ParticleTypes.CRIMSON_SPORE, 0.125F))
                        .waterColor(16743034)
                        .waterFogColor(4721171)
                        .fogColor(7895160)
                        .skyColor(197379)
                        .grassColor(4150633)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    public static void init(){
        Registry.register(Registry.CHUNK_GENERATOR, new Identifier("the_after", "the_after"), AfterChunkGenerator.CODEC);

        Registry.register(BuiltinRegistries.BIOME, AFTER_BIOME_KEY.getValue(), AFTER());
    }

}
