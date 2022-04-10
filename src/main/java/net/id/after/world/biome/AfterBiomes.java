package net.id.after.world.biome;


import net.id.after.world.gen.AfterChunkGenerator;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import static net.id.after.After.MOD_ID;

public class AfterBiomes {
    public static final RegistryKey<Biome> AFTER_BIOME_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(MOD_ID, "after_biome"));
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

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.NONE)
                .precipitation(Biome.Precipitation.NONE)
                //.depth(0.125F)
                //.scale(0.05F)
                .temperature(0.8F)
                .downfall(0.4F)
                .category(Biome.Category.FOREST)
                .effects((new BiomeEffects.Builder())
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
